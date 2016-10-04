package degea9.movies.data.api;

import degea9.movies.data.entity.MovieEntity;
import degea9.movies.data.entity.PopularMoviesResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by tuandang on 8/7/2016.
 */
public interface MovieApiService {
    @GET("discover/movie")
    Observable<PopularMoviesResponseEntity> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}?&append_to_response=reviews,trailers,casts")
    Observable<MovieEntity> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
