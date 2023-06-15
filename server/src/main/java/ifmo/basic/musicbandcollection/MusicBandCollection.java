package ifmo.basic.musicbandcollection;

import ifmo.basic.baseclasses.MusicBand;
import ifmo.basic.baseclasses.Studio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The Music Band Collection class is a collection based on Hashtable that extends the MusicBandHashtable class.
 * This class contains instance variables used to store information about music bands.
 *
 * @author a-nechaeva
 * @version 1.0
 * @see MusicBandHashtable
 * @see MusicBand
 * @since 13.06.2023
 */
public class MusicBandCollection extends MusicBandHashtable<Long, MusicBand>{
    /**
     * Instantiates a new MusicBandCollection object.
     */
    public MusicBandCollection() {
    }

    /**
     * prints the collection elements and its contents to the console
     *
     * @see MusicBand
     * @see Studio
     */
    public String show() {
        return Arrays.stream(this.values()).map(MusicBand::toString).collect(Collectors.joining("\n"));
    }

    /**
     * removes all elements with higher number of participants than given key from the collection.
     *
     * @param key the key to compare with.
     */
    public boolean removeGreater(Long key) {
        return Arrays.stream(this.values())
                .filter(musicBand -> musicBand.getNumberOfParticipants() > key)
                .map(musicBand -> this.removeByKey(musicBand.getId()))
                .reduce(false, (a, b) -> a || b);
    }
    /**
     * removes all elements with higher number of participants than given key from the collection.
     *
     * @param key the key to compare with.
     */
    public boolean removeLower(Long key) {
        return Arrays.stream(this.values())
                .filter(musicBand -> musicBand.getNumberOfParticipants() > key)
                .map(musicBand -> this.removeByKey(musicBand.getId()))
                .reduce(false, (a, b) -> a || b);
    }
    public boolean equals(MusicBandCollection musicBandHashtable) {
        MusicBand[] a = this.values();
        MusicBand[] b = musicBandHashtable.values();
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }


    /**
     * sorts the elements of the collection by the number of singles received in a reversed order and prints them.
     *
     * @see MusicBand
     */

    @Override
    public String printFieldDescendingSinglesCount() {
        MusicBand[] musicBands = getSortedMusicBandsBySinglesCount(true);
        return Arrays.stream(musicBands).map(Object::toString).collect(Collectors.joining("\n"));
    }

    /**
     * get the id of the element in the collection
     *
     * @param musicBand the element to get the id of
     * @return the id of the element or -1 if the element is not in the collection
     * @see MusicBand
     */
    @Override
    public Long getKey(MusicBand musicBand) {
        return musicBand.getId();
    }


    /**
     * get the elements of the collection
     *
     * @return MusicBand[]
     * @see MusicBand
     */
    @Override
    public MusicBand[] values() {
        return this.getHashtable().values().toArray(new MusicBand[this.size()]);
    }
/*
    /**
     * swap the elements if the provided elements has less Oscars than the element in the collection
     *
     * @param key   the key of the element in the collection
     * @param musicBand the element to compare with
     * @return true if the elements are swapped, false otherwise
     */
  /*  public boolean replaceLower(Long key, MusicBand musicBand) {
        if (movie.oscarsCount() < this.get(key).oscarsCount()) {
            this.update(key, movie);
            return true;
        }
        return false;
    }

   */

    /**
     * check if the collection contains such an element.
     *
     * @param musicBand the element to check
     * @return true if the element is in the collection, false otherwise
     * @see MusicBand
     */
    @Override
    public boolean contains(MusicBand musicBand) {
        return this.getHashtable().containsValue(musicBand);
    }

    /**
     * check if the collection contains such a key.
     *
     * @param key the key to check
     * @return true if the key is in the collection, false otherwise
     */
    public boolean isKeyPresented(Long key) {
        return this.getHashtable().containsKey(key);
    }

    @Override
    public MusicBand[] getSortedMusicBands(boolean reverse) {
        MusicBand[] musicBands = this.values();
        Arrays.sort(musicBands, (reverse) ? Comparator.reverseOrder() : Comparator.naturalOrder());
        return musicBands;
    }

    @Override
    public MusicBand[] getSortedMusicBandsBySinglesCount(boolean reverse) {
        return new MusicBand[0];
    }
/*
    /**
     * remove the elements with the specified rating from the collection.
     *
     * @param rating the rating to check
     * @return true if the operation was successful, false otherwise
     * @see MpaaRating
     */
  /*  public boolean removeByRating(MpaaRating rating) {
        Arrays.stream(this.values()).filter(movie -> movie.getRating() == rating).forEach(this::removeByValue);
        return true;
    }

   */
}
