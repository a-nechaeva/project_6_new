package commands.implemented;

import basic.baseclasses.Movie;
import commands.Action;
import server.response.MessagePainter;
import server.response.Response;
import server.response.ResponseType;

import java.util.Arrays;
import java.util.stream.Collectors;

import static server.UdpServer.collection;

public class ShowCommand implements Action {

    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(
                Arrays.stream(collection.values()).map(Movie::toString).collect(Collectors.joining("\n"))
        ), ResponseType.INFO);
    }
}
