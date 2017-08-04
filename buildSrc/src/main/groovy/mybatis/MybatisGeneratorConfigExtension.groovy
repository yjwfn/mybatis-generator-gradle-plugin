package mybatis

import mybatis.config.ClassPathEntry
import mybatis.config.Context
import mybatis.config.MybatisGeneratorConfig
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class MybatisGeneratorConfigExtension implements MybatisGeneratorConfig{

    Collection<Context> contexts
    Collection<ClassPathEntry> classPathEntries

    Instantiator instantiator
    Project project

    MybatisGeneratorConfigExtension(Project project,Instantiator instantiator){
        this.instantiator = instantiator
        this.project = project
        classPathEntries = new ArrayList<>()
        contexts = new ArrayList<>()
    }


    void context(Action<Context> configAction){
        Context context = instantiator.newInstance(ContextConfig.class,project, instantiator)
        configAction.execute(context)
        contexts.add(context)
     }

    void classPathEntry(ClassPathEntry classPathEntry){
        classPathEntries.add(classPathEntry)
    }

}
