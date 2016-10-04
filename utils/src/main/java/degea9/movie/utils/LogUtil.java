/**
 * Created by tuandang on 9/24/2016.
 */
package degea9.movie.utils;

import android.util.Log;

public class LogUtil {
    private static final boolean DEBUG = true;

    public static void d(String tag,String message){
        if(DEBUG){
            Log.d(tag,message);
        }
    }
}
