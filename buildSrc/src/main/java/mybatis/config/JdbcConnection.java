package mybatis.config;

/**
 * Created by yjwfn on 2017/8/3.
 */
public interface JdbcConnection {

    String getDriverClass();
    String getConnectionURL();
    String getUserId();
    String getPassword();

}
