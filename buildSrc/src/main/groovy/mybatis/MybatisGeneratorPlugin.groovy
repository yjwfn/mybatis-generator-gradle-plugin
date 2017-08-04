package mybatis

import mybatis.config.Context
import mybatis.config.MybatisGeneratorConfig
import mybatis.task.GenerateConfigurationTask
import mybatis.task.GenerateResources
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.internal.reflect.Instantiator
import org.gradle.invocation.DefaultGradle

/**
 * Created by yjwfn on 2017/8/3.
 */
class MybatisGeneratorPlugin implements Plugin<Project>{


    @Override
    void apply(Project project) {
        initial(project)
        applyTask(project)
    }


    void initial(Project project){

        DefaultGradle gradle = project.gradle
        Instantiator instantiator = gradle.services.get(Instantiator.class)
        project.extensions.create("mybatis", MybatisGeneratorConfigExtension.class, project, instantiator )
        project.configurations.create("generator", {})
    }


    void applyTask(Project project){
        Task generateConfigurationTask = project.tasks.create(name:"generateConfiguration", group: "mybatis", type: GenerateConfigurationTask, {
            outputs.file(project.file(project.buildDir.absolutePath + "/tmp/mybatis-generator.xml"))
            outputs.upToDateWhen  {false}
        })

        Task generateResources = project.tasks.create(name:"generateResources", group: "mybatis", type: GenerateResources, {
            inputs.files(generateConfigurationTask.outputs.files)
        })

        generateResources.dependsOn << "jar"

//        generateResources.convention.javaModelTargetProject = { project.file(context.javaModelGenerator.targetProject) }
//        generateResources.convention.javaClientTargetProject =  { project.file(context.javaClientGenerator.targetProject) }
//        generateResources.convention.sqlMapTargetProject = { project.file(context.sqlMapGenerator.targetProject) }
    }
}
