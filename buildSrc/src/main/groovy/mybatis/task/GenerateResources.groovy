package mybatis.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.classloader.MultiParentClassLoader
import org.mybatis.generator.api.MyBatisGenerator
import org.mybatis.generator.api.ShellCallback
import org.mybatis.generator.config.Configuration
import org.mybatis.generator.config.xml.ConfigurationParser
import org.mybatis.generator.internal.DefaultShellCallback
import org.mybatis.generator.internal.ObjectFactory
import org.mybatis.generator.internal.util.ClassloaderUtility

/**
 * Created by yjwfn on 2017/8/3.
 */
class GenerateResources extends DefaultTask{

//
//    @OutputFile
//    File javaModelTargetProject
//    @OutputFile
//    File javaClientTargetProject
//    @OutputFile
//    File sqlMapTargetProject


    @TaskAction
    void generateResources(){
        List<String> warnings = new ArrayList<>()
        ConfigurationParser configurationParser = new ConfigurationParser(warnings)
        Configuration configuration = configurationParser.parseConfiguration(inputs.files.singleFile)
        injectParentClassLoader(configuration)
        ShellCallback callback = new DefaultShellCallback(true)
        MyBatisGenerator generator = new MyBatisGenerator(configuration, callback, warnings)
        generator.generate(null)
    }

    void injectParentClassLoader(Configuration configuration ){
        ClassLoader externalClassLoader = ClassloaderUtility.getCustomClassloader(configuration.classPathEntries)
        Thread.currentThread().setContextClassLoader(externalClassLoader)
    }
}
