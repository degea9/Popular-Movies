/**
 * Created by tuandang on 9/25/2016.
 */
package degea9.movies.data.api;

import degea9.movie.utils.LogUtil;

public class ApiUtils {
    private static final String TAG = ApiUtils.class.getSimpleName();
    public static String buildPosterPath(String posterPath){
        String path = ApiConstant.BASE_POSTER_URL+posterPath;
        LogUtil.d(TAG,path);
        return path;
    }
}
