package mybatis

import mybatis.config.JdbcConnection

/**
 * Created by yjwfn on 2017/8/3.
 */
class JdbcConnectionConfig implements JdbcConnection{

    String driverClass
    String connectionURL
    String userId
    String password


}
