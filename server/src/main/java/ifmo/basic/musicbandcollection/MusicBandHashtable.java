package ifmo.basic.musicbandcollection;

import ifmo.server.ServerLogger;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

/**
 * The abstract class {@code MHMap} is a wrapper for the {@code HashMap} class.
 * It provides a set of methods for working with the {@code HashMap} class.
 * It is inherited by the {@code MovieCol} class.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 * @author dorlneylon
 * @see MusicBandCollection
 */
public abstract class MusicBandHashtable<K, V> {
    /**
     * A constant to represent the white color code in ANSI escape codes.
     */
    public static final String whcr = "\u001B[0m";

    /**
     * A constant to represent the purple color code in ANSI escape codes.
     */
    public static final String prcr = "\u001B[35m";
    private final ZonedDateTime initTime;
    /**
     * the map itself
     */
    private Hashtable<K, V> hashtable;

    /**
     * the default constructor
     */
    public MusicBandHashtable() {
        this.hashtable = new Hashtable<>();
        this.initTime = ZonedDateTime.now();
    }

    /**
     * the insert method
     */
    public boolean insert(V value) {
        try {
            this.hashtable.put(getKey(value), value);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    /**
     * insert with the given key
     */
    public boolean insert(K key, V value) {
        if (!this.hashtable.containsKey(key)) {
            this.hashtable.put(key, value);
            return true;
        } else {
            System.out.println("The value with this key already exists. Please, use the update command.");
            return false;
        }
    }

    public abstract String printFieldDescendingSinglesCount();

    /**
     * get the key by the value
     */
    public abstract K getKey(V value);

    /**
     * remove the value by the key
     */
    public boolean removeByKey(K key) {
        if (isKeyPresented(key)) {
            this.hashtable.remove(key);
            return true;
        }
        return false;
    }

    /**
     * get all the elements of the map in pairs ({@link K}, {@link V})
     */
    public Object[][] toArray() {
        Object[][] array = new Object[this.size()][2];
        int i = 0;
        for (K key : this.hashtable.keySet()) {
            array[i][0] = key;
            array[i][1] = this.hashtable.get(key);
            i++;
        }
        return array;
    }

    /**
     * remove the value from the hashtable
     */
    public void removeByValue(V val) {
        this.removeByKey(this.getKey(val));
    }

    /**
     * assign the hashtable
     */
    public void assign(MusicBandHashtable<K, V> hashtable) {
        this.hashtable = hashtable.getHashtable();
    }

    /**
     * get the value by the key
     */
    public V get(K key) {
        return this.hashtable.get(key);
    }

    /**
     * sort the hashtable elements by a comparator and print them
     */
  //  public abstract String printAscending();

    /**
     * reverse sort the map elements by a comparator and print them
     */
 //   public abstract String printDescending();

    /**
     * update the value by the key
     */
    public void update(K key, V value) {
        if (isKeyPresented(key)) {
            this.hashtable.put(key, value);
            ServerLogger.getLogger().info("Element with key " + key + " was successfully updated");
        } else System.out.println("No such value");
    }

    /**
     * update the value
     */
    public void update(V value) {
        this.update(this.getKey(value), value);
    }

    /**
     * get the init time
     */
    public java.time.ZonedDateTime getInitDate() {
        return this.initTime;
    }

    /**
     * clear the map
     */
    public void clear() {
        this.hashtable.clear();
    }

    /**
     * get the size of the map
     */
    public int size() {
        return this.hashtable.size();
    }

    /**
     * check if the map is empty
     */
    public boolean isEmpty() {
        return this.hashtable.isEmpty();
    }

    /**
     * check if the map contains the key for the value
     */
    public abstract boolean contains(V value);

    /**
     * check if the map contains a certain key
     */
    protected boolean isKeyPresented(K key) {
        return this.hashtable.containsKey(key);
    }

    /**
     * check if the map contains the value
     */
    protected boolean containsValue(V value) {
        return this.hashtable.containsValue(value);
    }

    /**
     * sort the values
     *
     * @return the sorted array of values
     */
    public abstract V[] getSortedMusicBands(boolean reverse);

    /**
     * sort the values
     *
     * @return the sorted array of values
     */
    public abstract V[] getSortedMusicBandsBySinglesCount(boolean reverse);

    /**
     * get the map
     */
    public Hashtable<K, V> getHashtable() {
        return this.hashtable;
    }

    /**
     * get the keys of the map
     */
    public abstract V[] values();

    /**
     * Print the information about the collection:
     * elements' type, date of initialization, number of elements, etc.
     */
    public String info() {
        Class<?> a = this.hashtable.isEmpty() ? null : this.hashtable.entrySet().stream().toList().get(0).getKey().getClass();
        String keyTypeName = a == null ? "none" : a.getName();
        return "Type: " + this.getClass().getName() + "\n"
                + "Key type: " + keyTypeName + "\n"
                + "Date of initialization: " + this.getInitDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\n"
                + "Number of elements: " + this.size();
    }

}
