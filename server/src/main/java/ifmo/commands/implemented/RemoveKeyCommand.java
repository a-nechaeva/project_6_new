package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.UdpServer;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;
public final class RemoveKeyCommand implements Action {
    private final Long key;

    public RemoveKeyCommand(Long key) {
        this.key = key;
    }

    @Override
    public Response run() {
        if (UdpServer.collection.removeByKey(key)) {
            return new Response("Movie with key %d deleted successfully".formatted(key), ResponseType.SUCCESS);
        }
        return new Response("It is not possible to delete a Movie with key=%d, because there is no Movie with this key.".formatted(key), ResponseType.ERROR);
    }
}
