/**
 * Created by tuandang on 9/13/2016.
 */
package degea9.movies.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import degea9.movies.data.api.ApiConstant;
import degea9.movies.data.api.MovieApiService;
import degea9.movies.data.entity.MovieEntity;
import degea9.movies.data.entity.PopularMoviesResponseEntity;
import degea9.movies.data.entity.mapper.MovieEntityDataMapper;
import degea9.movies.domain.model.MovieModel;
import degea9.movies.domain.repository.MovieRepository;
import rx.Observable;
import rx.functions.Func1;

/**
 * {@link MovieRepository} for retrieving user data.
 */
@Singleton
public class MovieDataRepository implements MovieRepository {


    MovieApiService movieApiService;
    private final MovieEntityDataMapper movieEntityDataMapper;
    /**
     * Constructs a {@link MovieDataRepository}.
     *
     * @param movieEntityDataMapper {@link MovieEntityDataMapper}.
     */
    @Inject
    public MovieDataRepository(MovieEntityDataMapper movieEntityDataMapper,MovieApiService movieApiService) {
        this.movieEntityDataMapper = movieEntityDataMapper;
        this.movieApiService = movieApiService;
    }


    @Override
    public Observable<List<MovieModel>> movies() {
        return movieApiService.getPopularMovies(ApiConstant.API_KEY).map(new Func1<PopularMoviesResponseEntity, List<MovieModel>>() {
            @Override
            public List<MovieModel> call(PopularMoviesResponseEntity popularMoviesResponseEntity) {
                return movieEntityDataMapper.transform(popularMoviesResponseEntity.getResults());
            }
        });
    }

    @Override
    public Observable<MovieModel> movie(int movieId) {
       return movieApiService.getMovieDetails(movieId,ApiConstant.API_KEY).map(movieEntity ->movieEntityDataMapper.transform(movieEntity));
        //movieEntity ->movieEntityDataMapper.transform(movieEntity);
    }
}
