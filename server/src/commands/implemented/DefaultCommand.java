package commands.implemented;

import commands.Action;
import server.response.Response;
import server.response.ResponseType;
public final class DefaultCommand  implements Action{
    @Override
    public Response run() {
        return new Response("Unknown command. To view command list use command 'help'", ResponseType.INFO);
    }
}
