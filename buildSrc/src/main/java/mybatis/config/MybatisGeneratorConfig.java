package mybatis.config;

import java.util.Collection;

/**
 * Created by yjwfn on 2017/8/3.
 */
public interface MybatisGeneratorConfig {

    Collection<Context> getContexts();
    Collection<ClassPathEntry> getClassPathEntries();

}
