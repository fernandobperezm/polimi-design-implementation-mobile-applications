package fernandoperez.moviesdiary.rest;

import fernandoperez.moviesdiary.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fernandoperez on 11/28/16.
 */

public interface MovieRestService {

    @GET("/?")
    public Call<Movie> getMovie(@Query("i") String imdbId);
}
