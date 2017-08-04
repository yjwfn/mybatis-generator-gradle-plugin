package mybatis.config;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class IgnoreColumn {
    private String column;

    public IgnoreColumn(String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
