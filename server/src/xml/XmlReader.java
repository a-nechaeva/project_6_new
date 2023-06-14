package xml;

import basic.baseclasses.MusicBand;
import basic.baseclasses.builders.Builder;
import basic.musicbandcollection.MusicBandCollection;
import server.ServerLogger;
import utils.string.StringUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import static utils.string.StringUtils.toCamelCase;
public class XmlReader extends XmlAction{
    public XmlReader(Xml xml) {
        super(xml);
    }

    private static Field findField(Object item, String fieldName) {
        return Arrays.stream(item.getClass().getDeclaredFields()).filter(f -> f.getName().equals(fieldName)).findFirst().orElse(null);
    }

    public MusicBandCollection parse() {
        MusicBandCollection musicBandCollection;
        musicBandCollection = readXML(xml.getXmlFile());
        // Checking product uniqueness
        if (musicBandCollection.size() > 1) {
            for (MusicBand musicBand : musicBandCollection.values()) {
                if (Arrays.stream(musicBandCollection.values()).anyMatch(p -> Objects.equals(p.getId(), musicBand.getId()) && p != musicBand)) {
                    ServerLogger.getLogger().warning("WARNING: MusicBand with id " + musicBand.getId() + " already exists");
                    ServerLogger.getLogger().warning("%Removing duplicates...");
                    musicBandCollection.removeByKey(musicBand.getId());
                }
            }
        }
        return musicBandCollection;
    }

    @Deprecated(forRemoval = true)
    public MusicBandCollection parse(File file) {
        MusicBandCollection musicBandCollection;
        musicBandCollection = readXML(file);
        return musicBandCollection;
    }

    private MusicBandCollection readXML(File file) throws RuntimeException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document;
        try {
            document = documentBuilderFactory.newDocumentBuilder().parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        document.normalizeDocument();
        Element root = document.getDocumentElement();
        NodeList rootTree = root.getChildNodes();
        MusicBandCollection musicBandCollection = new MusicBandCollection();
        for (int i = 0; i < rootTree.getLength(); i++) {
            Node node = rootTree.item(i);
            // Getting only Products
            if (node.getNodeName().equals("MusicBand")) {
                MusicBand musicBand;
                try {
                    musicBand = (MusicBand) parseItem(node);
                } catch (ClassNotFoundException e) {
                    ServerLogger.getLogger().warning(e.getMessage());
                    continue;
                }
                musicBandCollection.insert(musicBand);
            }
        }
        return musicBandCollection;
    }

    private Object parseItem(Node node) throws ClassNotFoundException {
        NodeList innerNodes = node.getChildNodes();
        // Getting builder's clazz
        Class<?> builderClass = Class.forName("%s.%sBuilder".formatted("itmo.lab6.basic.baseclasses.builders", StringUtils.capitalize(node.getNodeName())));
        Builder builder;
        try {
            builder = (Builder) builderClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            ServerLogger.getLogger().warning("Can't create instance of class");
            return null;
        } catch (InvocationTargetException | NoSuchMethodException e) {
            ServerLogger.getLogger().warning("Class %s doesn't have default constructor".formatted(node.getNodeName()));
            return null;
        }
        for (int j = 0; j < innerNodes.getLength(); j++) {
            Node item = innerNodes.item(j);
            // Skipping #text lines
            if (item instanceof Text) {
                continue;
            }
            // Checking if item is an object
            if (item.getChildNodes().getLength() > 1) {
                String fieldName = item.getNodeName().toLowerCase(); // fields of objects are in lower case
                setValueToField(builder, fieldName, parseItem(item));
            } else {
                setValueToField(builder, item.getNodeName(), item.getFirstChild().getNodeValue());
            }
        }
        return builder.build();
    }

    @SuppressWarnings("unchecked")
    protected <T> void setValueToField(Object item, String fieldName, T value) {
        if (item instanceof Collection<?>) {
            ((Collection<T>) item).add(value);
            return;
        }
        Field field = findField(item, toCamelCase(fieldName));
        if (field == null) {
            ServerLogger.getLogger().warning("Field %s not found".formatted(fieldName));
            return;
        }
        field.setAccessible(true);
        if (field.getType().isEnum()) {
            setEnumValue(field, item, value);
        } else {
            setFieldValue(field, item, value);
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private <T> void setEnumValue(Field field, Object item, T value) {
        try {
            field.set(item, Enum.valueOf((Class<Enum>) field.getType(), (String) value));
        } catch (IllegalAccessException e) {
            ServerLogger.getLogger().warning("Error while parsing enum. Check if value is enum or enum has this value: %s".formatted(value));
        }
    }

    private <T> void setFieldValue(Field field, Object item, T value) {
        try {
            Class<?> type = field.getType();
            if (value.equals("null")) {
                field.set(item, null);
                return;
            }
            field.set(item, switch (type.getSimpleName()) {
                case "ZonedDateTime" -> ZonedDateTime.parse(value.toString());
                case "Integer", "int" -> Integer.parseInt((String) value);
                case "Long", "long" -> Long.parseLong((String) value);
                case "Float", "float" -> Float.parseFloat((String) value);
                case "Double", "double" -> Double.parseDouble((String) value);
                case "Date" -> {
                    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                    yield format.parse(value.toString());
                }
                default -> value;
            });
        } catch (IllegalAccessException | ParseException e) {
            ServerLogger.getLogger().warning("Error while parsing %s. Check if value is %s".formatted(field.getType().getSimpleName(), field.getType().getSimpleName()));
        }
    }
}
