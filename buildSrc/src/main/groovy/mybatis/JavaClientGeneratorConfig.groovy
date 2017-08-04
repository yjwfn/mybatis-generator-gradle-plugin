package mybatis

import mybatis.config.JavaClientGenerator
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class JavaClientGeneratorConfig extends JavaModelGeneratorConfig implements JavaClientGenerator {

    String targetPackage
    String targetProject
    String type

    JavaClientGeneratorConfig(Project project, Instantiator instantiator) {
        super(project, instantiator)
    }
}
