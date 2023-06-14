import basic.musicbandcollection.MusicBandCollection;
import server.UdpServer;
import utils.config.Config;
import xml.Xml;

import java.io.File;
import java.io.IOException;


public class ServerMain {
    /**
     * Global variable with name of collection's xml file
     */
    public static String collectionFileName;
    private static Integer serverPort;

    static {
        Config config = new Config("server.scfg");
        collectionFileName = config.get("collection_file");
        if (collectionFileName == null) {
            // Setting up the default file name
            collectionFileName = "server.xml";
        }
        try {
            serverPort = Integer.parseInt(config.get("server_port"));
        } catch (NumberFormatException e) {
            // Setting up the default port
            serverPort = 5050;
        }
    }

    public static void main(String[] args) {
        MusicBandCollection collection;
        try {
            collection = new Xml(new File(collectionFileName)).newReader().parse();
        } catch (IOException e) {
            System.err.println("Unable to find collection file " + collectionFileName);
            System.err.println("New collection file will be created automatically after a few changes.");
            collection = new MusicBandCollection();
        }
        UdpServer server = new UdpServer(collection, serverPort);
        server.run();
    }
}
