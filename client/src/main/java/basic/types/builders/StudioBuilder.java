package basic.types.builders;

import basic.baseclasses.Studio;
import basic.baseenums.Color;
import basic.types.builders.annotations.NotNull;
import basic.types.builders.annotations.Value;
public class StudioBuilder implements Builder {
    private String name;
    @Override
    public Studio build() {
        return new Studio(name);
    }
}
