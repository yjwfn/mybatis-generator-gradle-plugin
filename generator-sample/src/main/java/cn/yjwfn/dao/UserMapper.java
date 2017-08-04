package cn.yjwfn.dao;

import cn.yjwfn.model.User;
import cn.yjwfn.model.UserExample;
import java.util.List;
import mybatis.DataSource;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    @DataSource("writeOnly")
    int deleteByExample(UserExample example);

    @DataSource("writeOnly")
    int deleteByPrimaryKey(Integer id);

    @DataSource("writeOnly")
    int insert(User record);

    @DataSource("writeOnly")
    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    @DataSource("writeOnly")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @DataSource("writeOnly")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @DataSource("writeOnly")
    int updateByPrimaryKeySelective(User record);

    @DataSource("writeOnly")
    int updateByPrimaryKey(User record);
}