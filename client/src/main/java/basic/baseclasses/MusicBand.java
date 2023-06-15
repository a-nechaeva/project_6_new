package basic.baseclasses;


import basic.auxiliary.Randomness;
import basic.baseenums.MusicGenre;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The `MusicBand` class represents a musicBand, which includes its name, creation date,
 * number of participants, genre, count of singles, and studio.
 *
 * @version 1.0
 * @since 13.06.2023
 */


public class MusicBand implements Comparable<MusicBand>, Serializable{
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    /**
     * Reset the ANSI color.
     */
    public static final String whcr = "\u001B[0m";

    /**
     * The ANSI color for blue.
     */
    public static final String blcr = "\u001B[34m";

    /**
     * the ANSI color for purple.
     */
    public static final String prcr = "\u001B[35m";
    /**
     * The next unique ID to be assigned to a musicBand instance.
     */
    private static Long nextId = Long.valueOf(1);

    /**
     * The unique ID of the musicBand.
     * Generates automatically, can't be null, greater than zero.
     */
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * The name of the musicBand. Can't be null and an empty sequence.
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * The coordinates of the musicBand. Can't be null
     * @see Coordinates
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * The creation date of the musicBand. Generates automatically, can't be null.
     */
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * The number of musicBand's participants. Not negative.
     */
    private int numberOfParticipants; //Значение поля должно быть больше 0
    /**
     * The number of singles of musicBand. Not negative.
     */
    private Integer singlesCount; //Поле может быть null, Значение поля должно быть больше 0
    /**
     * The establishment date of the musicBand.
     */
    private java.time.LocalDate establishmentDate; //Поле может быть null
    /**
     * The genre of the music.
     * @see MusicGenre
     */
    private MusicGenre genre; //Поле может быть null
    /**
     * The studio of the musicBand.
     * @see Studio
     */
    private Studio studio; //Поле может быть null

    /**
     * Constructor to create a musicBand with the given parameters.
     * Automatically sets the id and creation date for the musicBan.
     * @param name the name of the musicBan
     * @param coordinates the coordinates of the musicBan
     * @param numberOfParticipants the number of participants of the musicBan
     * @param singlesCount the number of singles of this musicBand
     * @param establishmentDate the date of establish of the musicBand
     * @param genre the genre of the musicBand
     * @param studio the studio of the musicBand

     * @see Coordinates
     * @see MusicGenre
     * @see Studio
     */

    public MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,
                     java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio){
        if (name == null || name.isEmpty() || coordinates == null ||
        numberOfParticipants < 0 || singlesCount < 0) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
        this.id = nextId++;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.studio = studio;
        this.creationDate = ZonedDateTime.now();
    }
    public MusicBand(Long id, String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,
                     java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null ||
                numberOfParticipants < 0 || singlesCount < 0) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.studio = studio;
        this.creationDate = ZonedDateTime.now();
    }
    /**
     * Constructs a `Movie` instance with the specified ID, name, coordinates, creation date,
     * number of Oscars, genre, MPAA rating, and director.
     *
     * @param name the name of the musicBan
     * @param coordinates the coordinates of the musicBan
     * @param numberOfParticipants the number of participants of the musicBan
     * @param singlesCount the number of singles of this musicBand
     * @param establishmentDate the date of establish of the musicBand
     * @param genre the genre of the musicBand
     * @param studio the studio of the musicBand
     * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,
     *                      java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
     */
    public MusicBand(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, int numberOfParticipants, Integer singlesCount,
                     java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio) {
        if (name == null || name.isEmpty() || coordinates == null ||
                numberOfParticipants < 0 || singlesCount < 0) throw new IllegalArgumentException("The fields can't be null or empty sequences.");
        nextId++;
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.ZonedDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.studio = studio;
        this.creationDate = ZonedDateTime.now();
    }
    /**
     * Constructs a `MusicBand` instance with the specified name, and random values for the other attributes.
     *
     * @param name the name of the movie
     * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,
     *                         java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
     */
    public MusicBand(String name)  {
        this.id = nextId++;
        this.name = name;
        this.coordinates = new Coordinates();
        this.creationDate = java.time.ZonedDateTime.now();
        this.numberOfParticipants = 0;
        this.singlesCount = 0;
        this.establishmentDate = LocalDate.of(1999, 1, 31);
        this.genre = Randomness.random(MusicGenre.class);
        this.studio = new Studio();
        this.creationDate = ZonedDateTime.now();
    }

    /**
     * Constructs a `MusicBand` instance with default values for all attributes.
     * @see MusicBand#MusicBand(String name, Coordinates coordinates, int numberOfParticipants, Integer singlesCount,
     *                            java.time.LocalDate establishmentDate, MusicGenre genre, Studio studio)
     */
    public MusicBand() {}

    /**
     * @return the name of the musicBand
     * @see MusicBand#name
     */
    public String getName() { return name; }

    /**
     * @return the unique ID of the musicBand
     * @see MusicBand#id
     * @see MusicBand#nextId
     */
    public Long getId(){return id;}

    /**
     * @return the coordinates of the musicBand
     * @see MusicBand#coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return the creation date of the musicBand
     * @see MusicBand#creationDate
     */
    public java.time.ZonedDateTime getCreationDate() {return creationDate;}

    /**
     * @return the genre of the musicBand
     * @see MusicBand#genre
     */
    public MusicGenre getGenre() {return genre;}

    /**
     * @return the studio of the musicBand
     * @see MusicBand#studio
     * @see Studio
     */
    public Studio getStudio() {return studio;}

    /**
     * @return the number of participants of the musicBand
     * @see MusicBand#numberOfParticipants
     */
    public int getNumberOfParticipants() {return numberOfParticipants;}

    /**
     * @return the count of singles of the musicBand
     * @see MusicBand#singlesCount
     */
    public Integer getSinglesCount() {return singlesCount;}

    /**
     * @return the establishment date
     * @see MusicBand#establishmentDate
     */
    public java.time.LocalDate getEstablishmentDate() {return establishmentDate;}

    /**
     * Use to set the name of the musicBand
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Used to set the coordinates of the musicBand
     * @see Coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    /**
     * Used to set the number of participants of musicBand.
     * @param numberOfParticipants
     * @see MusicBand#numberOfParticipants
     */
    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;    }

    /**
     * Used to set the count of singles of musicBand.
     * @param singlesCount
     * @see MusicBand#singlesCount
     */
    public void setSinglesCount(Integer singlesCount) {
        this.singlesCount = singlesCount;
    }

    /**
     * Used to set the genre of the musicBand.
     * @see MusicBand#genre
     * @see MusicGenre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre; }

    /**
     * Used to set the studio of the musicBand.
     * @see MusicBand#studio
     * @see Studio
     */
    public void setStudio(Studio studio) {
        this.studio = studio;
    }


    /**
     * Used to set the creation date of the musicBand.
     */
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Used to set the establish date of the musicBand.
     * @see MusicBand#establishmentDate
     */
    public void setEstablishmentDate(java.time.LocalDate establishmentDate) {

        this.establishmentDate = establishmentDate;
    }


    /**
     * Used to set the ID of the musicBand.
     */
    public void setId(Long id){
        this.id = id;
    }


    /**
     * Used to print the musicBand info.
     * @return the musicBand info
     * @see Studio#toString()
     */
    public String toString() {

        return "id = " + this.id +
                ", name = " + this.name +
                ", coordinates = " + this.coordinates +
                ", creationDate = " + this.creationDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")) +
                ", number of participants = " + this.numberOfParticipants +
                ", singles = " + this.singlesCount +
                ", establishment date = " + this.establishmentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", genre = " + this.genre +
                ", studio = " + this.studio;
    }

    @Override
    public int compareTo(MusicBand other) {
        int nameCompare = this.name.toLowerCase().compareTo(other.name.toLowerCase());
        if (nameCompare == 0)
            return (int) (this.getNumberOfParticipants() - other.getNumberOfParticipants());
        return this.name.toLowerCase().compareTo(other.name.toLowerCase());
    }
}
