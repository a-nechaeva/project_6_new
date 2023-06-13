package basic.baseclasses.builders;

import basic.baseclasses.Coordinates;
import basic.baseclasses.builders.annotations.NotNull;
import basic.baseclasses.builders.annotations.Value;

public class CoordinatesBuilder implements Builder {
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

