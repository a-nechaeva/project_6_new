package ifmo.commands.implemented;

import ifmo.basic.baseclasses.MusicBand;
import ifmo.commands.Action;
import ifmo.server.response.Response;
import ifmo.server.response.ResponseType;

import static ifmo.server.UdpServer.collection;
public final class InsertCommand implements Action {
    private final MusicBand musicBand;

    public InsertCommand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }

    @Override
    public Response run() {
        collection.insert(musicBand);
        return new Response("Insert was completed successfully", ResponseType.SUCCESS);
    }
}
