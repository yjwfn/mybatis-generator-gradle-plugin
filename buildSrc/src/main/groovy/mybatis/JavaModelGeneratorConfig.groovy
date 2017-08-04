package mybatis

import mybatis.config.JavaModelGenerator
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class JavaModelGeneratorConfig extends PropertyContainerConfig implements JavaModelGenerator{

    String targetPackage
    String targetProject

    JavaModelGeneratorConfig(Project project, Instantiator instantiator) {
        super(project, instantiator)
    }

}
