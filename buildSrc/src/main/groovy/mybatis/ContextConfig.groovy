package mybatis

import mybatis.config.*
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class ContextConfig  implements Context{

    String id
    String targetRuntime
    JdbcConnection jdbcConnection
    CommentGenerator commentGenerator
    JavaModelGenerator javaModelGenerator
    JavaClientGenerator javaClientGenerator
    SqlMapGeneratorConfig sqlMapGenerator
    Collection<Table>   tables
    Collection<Plugin>  plugins

    Instantiator instantiator

    ContextConfig(Project project, Instantiator instantiator){
        this.instantiator = instantiator
        jdbcConnection = instantiator.newInstance(JdbcConnectionConfig.class)
        commentGenerator = instantiator.newInstance(CommentGeneratorConfig.class, project, instantiator)
        javaModelGenerator = instantiator.newInstance(JavaModelGeneratorConfig.class, project, instantiator)
        javaClientGenerator = instantiator.newInstance(JavaClientGeneratorConfig.class, project, instantiator)
        sqlMapGenerator = instantiator.newInstance(SqlMapGeneratorConfig.class, project, instantiator)
        tables = project.container(Table.class, new TableFactory(instantiator))
        plugins = new ArrayList<>()
    }


    void jdbcConnection(Action<JdbcConnection> jdbcConnectionAction){
        jdbcConnectionAction.execute(jdbcConnection)
    }

    void commentGenerator(Action<CommentGenerator> commentGeneratorAction){
        commentGeneratorAction.execute(commentGenerator)
    }

    void javaModelGenerator(Action<JavaModelGenerator> generatorAction){
        generatorAction.execute(javaModelGenerator)
    }
    void javaClientGenerator(Action<JavaClientGenerator> clientGeneratorAction){
        clientGeneratorAction.execute(javaClientGenerator)
    }
    void sqlMapGenerator(Action<SqlMapGenerator> sqlMapGeneratorAction){
        sqlMapGeneratorAction.execute(sqlMapGenerator)
    }

    void plugin(String pluginType){
        plugins.add(
                instantiator.newInstance(PluginConfig.class, pluginType)
        )
    }


    void tables(Action<Collection> collectionAction){
        collectionAction.execute(tables)
    }
}
