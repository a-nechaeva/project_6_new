package basic.baseclasses.builders;

import basic.baseclasses.Studio;

public class StudioBuilder  implements Builder {
    private String name;
    @Override
    public Studio build() {
        return new Studio(name);
    }
}
