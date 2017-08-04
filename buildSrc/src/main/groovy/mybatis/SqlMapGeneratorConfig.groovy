package mybatis

import mybatis.config.SqlMapGenerator
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class SqlMapGeneratorConfig extends JavaModelGeneratorConfig implements SqlMapGenerator{

    String targetPackage
    String targetProject

    SqlMapGeneratorConfig(Project project, Instantiator instantiator) {
        super(project, instantiator)
    }
     
}
