package ifmo.commands.implemented;

import ifmo.commands.Action;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import static ifmo.server.UdpServer.collection;

public final class ServiceCommand implements Action {
    private final String command;

    public ServiceCommand(String command) {
        this.command = command;
    }

    @Override
    public Response run() {
        String[] splitCommand = command.split(" ");
        String commandPart = splitCommand[0];
        String arg = splitCommand[1];
        return switch (commandPart) {
            case "check_id" -> {
                Long id = Long.parseLong(arg);
                boolean isPresented = collection.isKeyPresented(id);
                yield new Response(Boolean.toString(isPresented), ResponseType.INFO);
            }
            default -> new Response("", ResponseType.INFO);
        };
    }
}
