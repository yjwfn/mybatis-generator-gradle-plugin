package mybatis.config;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class GenerateKey {
    private String column;
    private String sqlStatement;
    private boolean identity;

    public GenerateKey(String column, String sqlStatement, boolean identity) {
        this.column = column;
        this.sqlStatement = sqlStatement;
        this.identity = identity;
    }

    public String getColumn() {
        return column;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }

    public boolean getIdentity() {
        return identity;
    }
}
