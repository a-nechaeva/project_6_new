package basic.types.builders;

import basic.baseclasses.Coordinates;
import basic.types.builders.annotations.NotNull;
import basic.types.builders.annotations.Value;
public class CoordinatesBuilder implements Builder{
    @Value(min = -97)
    private Float x;
    @Value(min = -480)
    @NotNull
    private Double y;

    @Override
    public Coordinates build() {
        return new Coordinates(x, y);
    }
}
