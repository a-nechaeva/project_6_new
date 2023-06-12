package commands;

import basic.auxiliary.Convertible;
import basic.baseclasses.MusicBand;
import basic.utils.files.FileUtils;
import basic.utils.files.ScriptExecutor;
import basic.utils.parser.ArgumentParser;
import basic.utils.parser.UserInputParser;
import basic.utils.parser.exceptions.ObjectParsingException;
import basic.utils.terminal.Colors;
import connection.Connector;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import static commands.CollectionValidator.isMusicBandValid;

/**
 * This class is used to create new instances of {@link Command}
 */
public final class CommandFactory {
   // private static HashSet<CommandType> commandsHistory = new HashSet<>();

    /**
     * Returns new command instance {@link Command}
     *
     * @param type type of the command
     * @param args arguments to the command
     * @return command instance (can be null)
     */
    public static Command createCommand(CommandType type, String[] args) {
       // if (!type.equals(CommandType.DEFAULT)) commandsHistory.add(type);
        return switch (type) {
            case EXIT -> {
                System.out.println("Shutting down...");
                System.exit(0);
                yield null;
            }
            case EXECUTE_SCRIPT -> {
                if (args.length < 1) {
                    System.err.println("Not enough arguments for command " + CommandType.EXECUTE_SCRIPT);
                    yield null;
                }
                String filePath = args[0];
                if (!FileUtils.isFileExist(filePath)) {
                    System.err.println("Script file does not exist: " + filePath);
                    yield null;
                }
                ArrayList<Command> commands = new ScriptExecutor(new File(filePath)).readScript().getCommandList();
                yield new Command(type, commands);
            }
            case HELP, PRINT_FIELD_DESCENDING_SINGLES_COUNT, INFO, SHOW, CLEAR,
                    COUNT_BY_NUMBER_OF_PARTICIPANTS, GROUP_COUNTING_BY_NAME -> new Command(type);

            case REMOVE_GREATER, REMOVE_KEY, REMOVE_GREATER_KEY, REMOVE_LOWER -> {
                if (args.length < 1) {
                    System.err.println("Not enough arguments for command " + type.name());
                    yield null;
                }
                try {
                    yield new Command(type, Long.parseLong(args[0]));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid argument for command " + type.name());
                    yield null;
                }
            }
            case INSERT, UPDATE -> {
                MusicBand musicBand = null;
                if (args.length == 1) {
                    musicBand = parseMusicBand(type, args);
                } else if (args.length >= 2) {
                    musicBand = parseMusicBand(type, new String[]{args[0]}, Arrays.copyOfRange(args, 1, args.length));
                }
                if (musicBand != null) yield new Command(type, musicBand);
                yield null;
            }
            // DEFAULT command
            default -> {
                System.err.println("Unknown command.");
                yield null;
            }
        };
    }

    /**
     * Parses musicBand from console
     *
     * @param type command type
     * @param args command arguments
     * @return read musicBand from console
     */
    public static MusicBand parseMusicBand(CommandType type, String[] args) {
        if (Boolean.FALSE.equals(isMusicBandValid(type, args))) return null;

        MusicBand musicBand = new UserInputParser().readObject(MusicBand.class);
        Objects.requireNonNull(musicBand).setId(Long.parseLong(args[0]));
        return musicBand;
    }

    /**
     * Parses musicBand from file
     *
     * @param args          command args
     * @param musicBandArgs musicBand args
     * @return read musicBand from file
     */
    public static MusicBand parseMusicBand(CommandType type, String[] args, String[] musicBandArgs) {
        MusicBand musicBand = null;
        try {
            musicBand = new ArgumentParser(musicBandArgs).readObject(MusicBand.class);
            Objects.requireNonNull(musicBand).setId(Long.parseLong(args[0]));
        } catch (ObjectParsingException e) {
            System.err.println("Error parsing: " + e.getMessage());
        }
        return musicBand;
    }
}

