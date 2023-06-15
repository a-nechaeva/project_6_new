package ifmo.commands.implemented;

import ifmo.basic.baseclasses.MusicBand;
import ifmo.commands.Action;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import static ifmo.server.UdpServer.collection;

public class UpdateCommand implements Action {
    private final MusicBand musicBand;

    public UpdateCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    @Override
    public Response run() {
        if (!collection.isKeyPresented(musicBand.getId())) return new Response("Collection does not contain such a key", ResponseType.SUCCESS);
        collection.update(musicBand);

        return new Response("Update was completed successfully", ResponseType.SUCCESS);
    }
}
