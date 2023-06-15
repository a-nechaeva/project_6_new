package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.commands.Command;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import java.util.ArrayList;
public final class ExecuteScriptCommand implements Action {
    private final ArrayList<Command> commandQueue;

    public ExecuteScriptCommand(ArrayList<Command> commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public Response run() {
        if (commandQueue.size() == 0) return new Response("The command queue is empty", ResponseType.ERROR);
        StringBuilder output = new StringBuilder();
        commandQueue.forEach(command -> output.append(command.execute().getMessage()).append("\n"));
        return new Response(output.substring(0, output.length() - 1), ResponseType.SUCCESS);
    }
}
