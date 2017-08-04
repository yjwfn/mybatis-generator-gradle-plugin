package mybatis;



import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class DataSourcePlugin extends PluginAdapter {


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }


    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        interfaze.addImportedType(new FullyQualifiedJavaType(DataSource.class.getName()));
        List<Method> methodList = interfaze.getMethods();
        for(Method method: methodList){
            String methodName = method.getName();

            if(methodName.startsWith("insert")
                    || methodName.startsWith("update")
                    || methodName.startsWith("del")){

                method.addAnnotation("@DataSource(\"writeOnly\")");
            }
        }

        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }
}
