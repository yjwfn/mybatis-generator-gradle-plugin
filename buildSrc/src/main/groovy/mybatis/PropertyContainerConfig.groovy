package mybatis

import mybatis.config.Property
import mybatis.config.PropertyContainer
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class PropertyContainerConfig extends PropertyContainer{


    Instantiator instantiator

    PropertyContainerConfig(Project project, Instantiator instantiator){
        this.instantiator = instantiator
        properties = new ArrayList<>()
    }

    void properties(Action<Collection<Property>> action){
        action.execute(properties)
    }

    void property(String name, String value){
        properties.add(
                instantiator.newInstance(Property.class, name, value)
        )

    }

}
