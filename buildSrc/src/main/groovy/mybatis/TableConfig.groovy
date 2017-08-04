package mybatis

import mybatis.config.ColumnOverride
import mybatis.config.GenerateKey
import mybatis.config.IgnoreColumn
import mybatis.config.Table
import org.gradle.internal.reflect.Instantiator

/**
 * Created by yjwfn on 2017/8/3.
 */
class TableConfig implements Table{

    String name
    String tableName
    String domainObjectName
    GenerateKey generateKey
    Collection<IgnoreColumn> ignoreColumns
    Collection<ColumnOverride> columnOverrides

    Instantiator instantiator

    TableConfig(Instantiator instantiator, String tableName) {
        this.instantiator = instantiator
        ignoreColumns = new ArrayList<>()
        columnOverrides = new ArrayList<>()

        this.name = this.tableName = tableName
    }

    void generateKey(String column, String sqlStatement, boolean identity){
        generateKey = instantiator.newInstance(GenerateKey.class, column, sqlStatement, identity)
    }


    void ignoreColumn(String column){
        ignoreColumns.add(
                instantiator.newInstance(IgnoreColumn.class, column)
        )
    }

    void columnOverride(String column, String jdbcType){
        columnOverrides.add(
                instantiator.newInstance(ColumnOverride.class, column, jdbcType)
        )
    }

}
