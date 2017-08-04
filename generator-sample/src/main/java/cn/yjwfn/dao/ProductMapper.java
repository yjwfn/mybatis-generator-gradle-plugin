package cn.yjwfn.dao;

import cn.yjwfn.model.Product;
import cn.yjwfn.model.ProductExample;
import cn.yjwfn.model.ProductWithBLOBs;
import java.util.List;
import mybatis.DataSource;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    @DataSource("writeOnly")
    int deleteByExample(ProductExample example);

    @DataSource("writeOnly")
    int deleteByPrimaryKey(Integer id);

    @DataSource("writeOnly")
    int insert(ProductWithBLOBs record);

    @DataSource("writeOnly")
    int insertSelective(ProductWithBLOBs record);

    List<ProductWithBLOBs> selectByExampleWithBLOBs(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    ProductWithBLOBs selectByPrimaryKey(Integer id);

    @DataSource("writeOnly")
    int updateByExampleSelective(@Param("record") ProductWithBLOBs record, @Param("example") ProductExample example);

    @DataSource("writeOnly")
    int updateByExampleWithBLOBs(@Param("record") ProductWithBLOBs record, @Param("example") ProductExample example);

    @DataSource("writeOnly")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @DataSource("writeOnly")
    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    @DataSource("writeOnly")
    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    @DataSource("writeOnly")
    int updateByPrimaryKey(Product record);
}