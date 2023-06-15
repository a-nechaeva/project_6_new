package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;
public final class DefaultCommand  implements Action {
    @Override
    public Response run() {
        return new Response("Unknown command. To view command list use command 'help'", ResponseType.INFO);
    }
}
