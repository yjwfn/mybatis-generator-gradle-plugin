package mybatis

import mybatis.config.Table
import org.gradle.api.NamedDomainObjectFactory
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class TableFactory implements NamedDomainObjectFactory<Table>{

    Instantiator instantiator

    TableFactory(Instantiator instantiator){
        this.instantiator = instantiator
    }

    @Override
    Table create(String s) {
        return instantiator.newInstance(TableConfig.class, instantiator, s)
    }
}