/**
 * Created by tuandang on 9/27/2016.
 */
package degea9.movies.data.entity;

import com.google.gson.annotations.SerializedName;

public class TrailerEntity {
    @SerializedName("name")
    private String name;
    @SerializedName("size")
    private String size;
    @SerializedName("source")
    private String source;
    @SerializedName("type")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
