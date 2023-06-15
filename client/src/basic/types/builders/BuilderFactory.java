package basic.types.builders;

public class BuilderFactory {
    public static Builder getBuilder(String className) {
        return switch (className.toLowerCase()) {
            case "coordinates" -> new CoordinatesBuilder();
            case "date" -> new DateBuilder();
            case "studio" -> new StudioBuilder();
            case "music_band" -> new MusicBandBuilder();
            default -> null;
        };
    }
}
