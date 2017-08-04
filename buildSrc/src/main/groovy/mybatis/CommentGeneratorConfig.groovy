package mybatis

import mybatis.config.CommentGenerator
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class CommentGeneratorConfig  extends PropertyContainerConfig implements CommentGenerator{

    CommentGeneratorConfig(Project project, Instantiator instantiator) {
        super(project, instantiator)

    }
}
