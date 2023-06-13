package commands.implemented;

import commands.Action;
import commands.CommandType;
import server.response.MessagePainter;
import server.response.Response;
import server.response.ResponseType;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class HelpCommand  implements Action{
    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(Arrays.stream(CommandType.values()).
                map(CommandType::getDescription).
                filter(description -> !description.isEmpty()).
                collect(Collectors.joining("\n"))), ResponseType.INFO);
    }
}
