package mybatis

import mybatis.config.Plugin

/**
 * Created by yjwfn on 2017/8/3.
 */
class PluginConfig implements Plugin{
    String type

    PluginConfig(String type) {
        this.type = type
    }
}
