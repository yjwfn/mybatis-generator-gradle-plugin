package mybatis.task

import com.google.common.io.Files
import mybatis.config.ClassPathEntry
import mybatis.config.Context
import mybatis.config.MybatisGeneratorConfig
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.artifacts.Configuration
import org.gradle.api.tasks.TaskAction

/**
 * Created by yjwfn on 2017/8/3.
 */
class GenerateConfigurationTask extends DefaultTask{

    static final String CONFIGURATION_TEMPLATE_NAME = "mybatis-generator.vm"
    static final String GENERATOR_GRADLE_CONFIG = "generator"


    @TaskAction
    void generate(){
        MybatisGeneratorConfig config = project.extensions.findByName("mybatis")
        List<Context> contexts = config.contexts
        Properties velocityProperties = new Properties()
        velocityProperties.setProperty("resource.loader", "class")
        velocityProperties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" )

        Velocity.init(velocityProperties)
        VelocityContext velocityContext = new VelocityContext()
        velocityContext.put("contexts", contexts)
        applyClassPathEntities(config, velocityContext)

        File configTargetPath = outputs.files.singleFile
        Files.createParentDirs(configTargetPath)
        FileWriter fileWriter = new FileWriter(configTargetPath)
        Velocity.mergeTemplate(CONFIGURATION_TEMPLATE_NAME, "utf-8" , velocityContext,  fileWriter)
        fileWriter.close()

    }


    void applyClassPathEntities(MybatisGeneratorConfig config, VelocityContext velocityContext){

        project.configurations.each {
            it.resolve().each {
                config.classPathEntries.add(new ClassPathEntry(it.absolutePath))

            }
        }


        Task jarTask = project.tasks.findByName("jar")
        config.classPathEntries.add(new ClassPathEntry(jarTask.outputs.files.singleFile.absolutePath))
        velocityContext.put("classPathEntries", config.classPathEntries)
    }


}
