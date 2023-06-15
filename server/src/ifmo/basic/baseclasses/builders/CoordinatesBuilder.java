package ifmo.basic.baseclasses.builders;

import ifmo.basic.baseclasses.Coordinates;
import ifmo.basic.baseclasses.builders.annotations.NotNull;
import ifmo.basic.baseclasses.builders.annotations.Value;

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

