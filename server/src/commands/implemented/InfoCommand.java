package commands.implemented;

import commands.Action;
import server.UdpServer;
import server.response.MessagePainter;
import server.response.Response;
import server.response.ResponseType;
public final class InfoCommand implements Action{
    @Override
    public Response run() {
        return new Response(MessagePainter.ColoredInfoMessage(UdpServer.collection.info()), ResponseType.INFO);
    }
}
