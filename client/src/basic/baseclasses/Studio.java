package basic.baseclasses;

import basic.auxiliary.Randomness;
import basic.baseenums.Color;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * The `Person` class implements `Serializable` interface and is used to store information about a person.
 * It has various instance variables to store the person's name, birthday, height, hair color, and location.
 * The class provides constructors with different parameters and getters and setters for all the instance variables.
 * It also provides an implementation of the `toString()` method for convenient output.
 *
 * @author zxc nylon
 * @version 1.0
 * @since 1999
 */
public class Studio implements Serializable{
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    /**
     * A constant to represent the white color code in ANSI escape codes.
     */
    public static final String whcr = "\u001B[0m";
    /**
     * The ANSI color for blue.
     */
    public static final String blcr = "\u001B[34m";

    /**
     * A constant to represent the purple color code in ANSI escape codes.
     */
    public static final String prcr = "\u001B[35m";

    /**
     * The name of the studio
     */
    private String name; //Поле может быть null


    /**
     * Returns the name of the studio
     *
     * @return The name of the studio
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the studio
     *
     * @param name The name of the studio
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new `Studio` object with standard parameters.
     */
    public Studio() {
        this.name = "Rose";

    }
    /**
     * Creates a new `Studio` object with the specified parameters.
     *
     * @param name The name of the person.
     */
    public Studio(String name) {
        this.name = name;
    }


    public boolean equals(Studio p) {
        return this.name.equals(p.name);
    }


    @Override
    public String toString() {
        return name;
    }
}
