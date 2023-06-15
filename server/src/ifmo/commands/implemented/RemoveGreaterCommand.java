package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.UdpServer;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;
public final class RemoveGreaterCommand implements Action {
    private final Long key;

    public RemoveGreaterCommand(Long key) {
        this.key = key;
    }

    @Override
    public Response run() {
        if (UdpServer.collection.removeGreater(key)) {
            return new Response("Greater elements have been successfully deleted", ResponseType.SUCCESS);
        }
        return new Response("There are no items in the collection larger than a given", ResponseType.ERROR);
    }
}
