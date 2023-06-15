package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.commands.CommandType;
import ifmo.server.response.MessagePainter;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class HelpCommand  implements Action {
    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(Arrays.stream(CommandType.values()).
                map(CommandType::getDescription).
                filter(description -> !description.isEmpty()).
                collect(Collectors.joining("\n"))), ResponseType.INFO);
    }
}
