package mybatis.config;

import java.util.Collection;

/**
 * Created by yjwfn on 2017/8/3.
 */
public interface Table {
    String getTableName();
    String getDomainObjectName();
    GenerateKey getGenerateKey();
    Collection<IgnoreColumn> getIgnoreColumns();
    Collection<ColumnOverride> getColumnOverrides();
}
