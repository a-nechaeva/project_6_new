package commands.implemented;

import commands.Action;
import server.UdpServer;
import server.response.Response;
import server.response.ResponseType;

public final class ClearCommand  implements Action{
    @Override
    public Response run() {
        UdpServer.collection.clear();
        return new Response("Collection cleaned successfully", ResponseType.SUCCESS);
    }
}
