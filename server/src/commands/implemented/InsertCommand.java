package commands.implemented;

import basic.baseclasses.Movie;
import commands.Action;
import server.response.Response;
import server.response.ResponseType;

import static server.UdpServer.collection;
public final class InsertCommand implements Action{
    private final Movie movie;

    public InsertCommand(Movie movie) {
        this.movie = movie;
    }

    @Override
    public Response run() {
        collection.insert(movie);
        return new Response("Insert was completed successfully", ResponseType.SUCCESS);
    }
}
