package basic.musicbandcollection;

import basic.baseclasses.MusicBand;
import basic.baseclasses.Studio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * The MovieCol class is a collection based on HashMap that extends the MHMap class.
 * This class contains instance variables used to store information about movies.
 *
 * @author dorlneylon
 * @version 1.0?
 * @see MusicBandHashtable
 * @see MusicBand
 * @since 03.02.2023
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
     * removes all elements with higher oscarsCount than given key from the collection.
     *
     * @param key the key to compare with.
     */
    public boolean removeGreater(Long key) {
        return Arrays.stream(this.values())
                .filter(movie -> movie.getOscarsInt() > key)
                .map(movie -> this.removeByKey(movie.getId()))
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
     * sorts the elements of the collection by the number of Oscars received and prints them in a new order.
     *
     * @see MusicBand
     */
    @Override
    public String printAscending() {
        MusicBand[] musicBands = getSortedMusicBands(false);
        return Arrays.stream(musicBands).map(Object::toString).collect(Collectors.joining("\n"));
    }

    /**
     * sorts the elements of the collection by the number of Oscars received in a reversed order and prints them.
     *
     * @see MusicBand
     */
    @Override
    public String printDescending() {
        MusicBand[] musicBands = getSortedMusicBands(true);
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

    /**
     * swap the elements if the provided elements has less Oscars than the element in the collection
     *
     * @param key   the key of the element in the collection
     * @param musicBand the element to compare with
     * @return true if the elements are swapped, false otherwise
     */
    public boolean replaceLower(Long key, MusicBand musicBand) {
        if (movie.oscarsCount() < this.get(key).oscarsCount()) {
            this.update(key, movie);
            return true;
        }
        return false;
    }

    /**
     * check if the collection contains such an element.
     *
     * @param movie the element to check
     * @return true if the element is in the collection, false otherwise
     * @see Movie
     */
    @Override
    public boolean contains(Movie movie) {
        return this.getMap().containsValue(movie);
    }

    /**
     * check if the collection contains such a key.
     *
     * @param key the key to check
     * @return true if the key is in the collection, false otherwise
     */
    public boolean isKeyPresented(Long key) {
        return this.getMap().containsKey(key);
    }

    @Override
    public Movie[] getSortedMovies(boolean reverse) {
        Movie[] movies = this.values();
        Arrays.sort(movies, (reverse) ? Comparator.reverseOrder() : Comparator.naturalOrder());
        return movies;
    }

    /**
     * remove the elements with the specified rating from the collection.
     *
     * @param rating the rating to check
     * @return true if the operation was successful, false otherwise
     * @see MpaaRating
     */
    public boolean removeByRating(MpaaRating rating) {
        Arrays.stream(this.values()).filter(movie -> movie.getRating() == rating).forEach(this::removeByValue);
        return true;
    }
}
