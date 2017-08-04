package mybatis.config;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class ColumnOverride {
    private String column;
    private String jdbcType;

    public ColumnOverride(String column, String jdbcType) {
        this.column = column;
        this.jdbcType = jdbcType;
    }


    public String getColumn() {
        return column;
    }

    public String getJdbcType() {
        return jdbcType;
    }
}
