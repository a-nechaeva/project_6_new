package ifmo.basic.baseclasses;

import ifmo.basic.baseclasses.builders.annotations.Generated;


import java.io.Serial;
import java.io.Serializable;


/**
 * The `Studio` class implements `Serializable` interface and is used to store information about a studio.
 * It has instance variable to store the studio's name.
 * It also provides an implementation of the `toString()` method for convenient output.
 *
 * @version 1.0
 * @since 13.06.2023
 */
public class Studio implements Serializable {
    @Serial
    @Generated
    private static final long serialVersionUID = 6529685098267757690L;

    /**
     * The name of the person.
     */
    private String name;


    /**
     * Creates a new `Studio` object with the specified parameter.
     *
     * @param name      The name of the studio.
     */
    public Studio(String name) {
        this.name = name;
    }


    /**
     * Creates a new `Studio` object with standard parameter.
     */
    public Studio() {
        this.name = "Red Roses";
    }

    /**
     * Returns the name of the studio.
     *
     * @return The name of the studio.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the studio.
     *
     * @param name The name of the studio.
     */
    public void setName(String name) {
        this.name = name;
    }


    public boolean equals(Studio p) {
        return this.name.equals(p.name);
    }

    @Override
    public String toString() {
               return "Studio's name: " + name + ",\n";

    }
}
