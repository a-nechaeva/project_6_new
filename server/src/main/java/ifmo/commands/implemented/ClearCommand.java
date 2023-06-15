package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.UdpServer;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

public final class ClearCommand  implements Action {
    @Override
    public Response run() {
        UdpServer.collection.clear();
        return new Response("Collection cleaned successfully", ResponseType.SUCCESS);
    }
}
