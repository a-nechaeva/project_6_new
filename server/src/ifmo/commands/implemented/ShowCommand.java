package ifmo.commands.implemented;


import ifmo.basic.baseclasses.MusicBand;
import ifmo.commands.Action;
import ifmo.server.response.MessagePainter;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import java.util.Arrays;
import java.util.stream.Collectors;

import static ifmo.server.UdpServer.collection;

public class ShowCommand implements Action {

    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(
                Arrays.stream(collection.values()).map(MusicBand::toString).collect(Collectors.joining("\n"))
        ), ResponseType.INFO);
    }
}
