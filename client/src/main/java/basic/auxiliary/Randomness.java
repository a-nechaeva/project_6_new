package basic.auxiliary;

/**
 * The `Randomness` class is used to generate random values.
 * It has a single method `random()` that is used to generate a random value. What a surprise.
 */
public class Randomness {
    public static <E extends Enum<E>> E random(Class<E> e) {
        return e.getEnumConstants()[(int) (Math.random() * e.getEnumConstants().length)];
    }
}
