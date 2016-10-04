/**
 * Created by tuandang on 9/24/2016.
 */
package degea9.movies.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import degea9.movies.data.api.ApiConstant;
import degea9.movies.data.api.MovieApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public MovieApiService provideMovieApiService(Retrofit restAdapter) {
        return restAdapter.create(MovieApiService.class);
    }
}
