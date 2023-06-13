package basic.baseclasses.builders;

import basic.baseclasses.Coordinates;
import basic.baseclasses.MusicBand;
import basic.baseclasses.Studio;
import basic.baseclasses.builders.annotations.Generated;
import basic.baseclasses.builders.annotations.NotNull;
import basic.baseclasses.builders.annotations.Value;
import basic.baseenums.MusicGenre;

import java.time.ZonedDateTime;

public class MusicBandBuilder implements Builder{
    @NotNull
    @Generated
    @Value(min = 0)
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private Coordinates coordinates;
    @NotNull
    @Generated
    private ZonedDateTime creationDate;

    @Value(min = 1)
    private int numberOfParticipants;

    @Value(min = 1)
    private Integer singlesCount;

    private java.time.LocalDate establishmentDate;

    private MusicGenre genre;

    private Studio studio;

    @Override
    public MusicBand build() {
        return new MusicBand(id, name, coordinates, creationDate, numberOfParticipants,singlesCount, establishmentDate, genre, studio);
    }
}
