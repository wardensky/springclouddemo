package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.caches.memcached.MemcachedCache;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 * 
 * 需要注意的是：这个接口中不可以定义同名的方法，因为会生成相同的id
 * 也就是说这个接口是不支持重载的
 */
@Mapper
@CacheNamespace(implementation = (MemcachedCache.class))
public interface UserDao {

	public List<User> selectAll();
	
	@Select("select id, n1, n2, n3, n4, n5, n6, create_time createTime from user limit 1")
	@Options(useCache = true)
	public User selectFirst();
	
	/*#{}和${}的区别
	  #{}: mybatis会进行加引号的操作，将参数转变为一个字符串
	  ${}: mybatis不会进行任何的处理，直接生成sql语句
	  谨慎使用${}，因为${}会引起sql注入, 直接参与sql编译
	*/
	@Select("select id, n1, n2, n3, n4, n5, n6, create_time createTime from user where n1 = #{n1} limit 1")
	@Options(useCache = false)
	public User selectByN1(String n1);
	
	//关于trim https://blog.csdn.net/death05/article/details/53098328
	@Select("<script>"
			+"select id, n1, n2, n3, n4, n5, n6, create_time createTime from user"
			+"<trim prefix='where' prefixOverrides='and|or'>"
			+"<if test='n4 != null and n4.length >0'> and n4 = #{n4} </if>"
			+"<if test='n5 != null and n5.length >0'> and n5 = #{n5} </if>"
			+"</trim>"
			+"</script>")
	//userList定义在mappers/UserMapper.xml
	//@ResultMap("userList")
	public List<User> selectByN4N5(@Param("n4")String n4, @Param("n5")String n5);
	
	@SelectProvider(type = UserProvider.class, method = "selByN4N5")
	public List<User> selByN4N5(@Param("n4")String n4, @Param("n5")String n5);
}
