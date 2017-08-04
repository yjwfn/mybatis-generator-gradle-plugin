package mybatis;

/**
 * Created by yjwfn on 2017/8/4.
 */
public @interface DataSource {
    String value() default "readOnly";
}
