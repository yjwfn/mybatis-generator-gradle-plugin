package mybatis.config;

import java.util.Collection;

/**
 * Created by yjwfn on 2017/8/3.
 */
public interface JavaModelGenerator  {
    Collection<Property> getProperties();
    String getTargetPackage();
    String getTargetProject();
}
