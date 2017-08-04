package mybatis.config;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class Property {
    private String name;
    private String value;

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
