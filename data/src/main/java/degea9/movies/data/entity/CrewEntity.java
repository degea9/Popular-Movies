/**
 * Created by tuandang on 9/25/2016.
 */
package degea9.movies.data.entity;

import com.google.gson.annotations.SerializedName;

public class CrewEntity {
    @SerializedName("credit_id")
    private Integer creditId;
    @SerializedName("department")
    private String department;
    @SerializedName("id")
    private Integer id;
    @SerializedName("job")
    private String job;
    @SerializedName("name")
    private String name;

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    @SerializedName("profile_path")
    private String profilePath;
}
