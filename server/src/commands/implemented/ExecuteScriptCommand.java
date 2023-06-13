package commands.implemented;

import commands.Action;
import commands.Command;
import server.response.Response;
import server.response.ResponseType;

import java.util.ArrayList;
public final class ExecuteScriptCommand implements Action{
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
