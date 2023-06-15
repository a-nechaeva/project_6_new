package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.UdpServer;
import ifmo.server.response.MessagePainter;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;
public final class InfoCommand implements Action {
    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(UdpServer.collection.info()), ResponseType.INFO);
    }
}
