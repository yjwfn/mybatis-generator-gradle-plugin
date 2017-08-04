package mybatis.config;

import java.util.Collection;

/**
 * Created by yjwfn on 2017/8/3.
 */
public interface Context {

     String getId();
     String getTargetRuntime();
     JdbcConnection getJdbcConnection();
     JavaModelGenerator getJavaModelGenerator();
     JavaClientGenerator getJavaClientGenerator();
     SqlMapGenerator getSqlMapGenerator();
     Collection<Table> getTables();
     Collection<Plugin> getPlugins();


}
