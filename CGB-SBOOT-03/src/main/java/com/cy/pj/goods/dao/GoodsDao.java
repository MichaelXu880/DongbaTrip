package com.cy.pj.goods.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.goods.pojo.Goods;

/**
 * GoodsDao 是一个数据层商品信息访问接口
 * @Mapper 注解由Mapper框架提供，此注解描述的接口由mybatis框架创建其实现类，
 * 并交给spring容器管理，对象的名字默认为接口名，然后首字母小写。
 */
@Mapper
public interface GoodsDao {

	   /**
	    * 将内存中的对象存储到数据库
	    * @param entity
	    * @return
	    */
	   @Insert("insert into tb_goods (name,remark,createdTime) values (#{name},#{remark},now())")
	   int insertObject(Goods entity);
	   /**
	    * 查询所有商品信息
	    * @return
	    */
	   @Select("select id,name,remark,createdTime from tb_goods")
	   List<Goods> findObjects();
	
	   /**
	    * 基于多个商品id删除商品信息
	    * @param ids
	    * @return
	    */
	  int deleteObjects(@Param("ids")Integer...ids);//三个点为可变参数(可理解为特殊数组)
	
      /**基于商品id删除商品信息
       * MyBatis框架中定义SQL映射方式有两种：
       * 1)注解 (简单sql)
       * 2)xml (复杂sql)
       * */
	  @Delete("delete from tb_goods where id=#{id}")
	  int deleteById(Integer id);
}



