package mybatis.config;

/**
 * Created by yjwfn on 2017/8/4.
 */
public class ClassPathEntry {

    private String location;

    public ClassPathEntry(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
