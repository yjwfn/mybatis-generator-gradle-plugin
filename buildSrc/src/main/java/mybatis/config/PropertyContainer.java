package mybatis.config;

import java.util.Collection;

/**
 * Created by yjwfn on 2017/8/3.
 */
public class PropertyContainer {
  private Collection<Property> properties;

  public   Collection<Property> getProperties(){
      return properties;
  }

    public void setProperties(Collection<Property> properties) {
        this.properties = properties;
    }
}
