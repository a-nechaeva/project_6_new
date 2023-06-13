package commands.implemented;

import basic.baseclasses.Movie;
import commands.Action;
import server.response.Response;
import server.response.ResponseType;

import static server.UdpServer.collection;

public class UpdateCommand implements Action {
    private final Movie movie;

    public UpdateCommand(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Response run() {
        if (!collection.isKeyPresented(movie.getId())) return new Response("Collection does not contain such a key", ResponseType.SUCCESS);
        collection.update(movie);

        return new Response("Update was completed successfully", ResponseType.SUCCESS);
    }
}
