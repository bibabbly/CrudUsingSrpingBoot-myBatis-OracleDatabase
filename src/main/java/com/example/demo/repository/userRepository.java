package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface userRepository {
	
	@Select("SELECT * FROM USER_TB")
	List<User> findAllUsers();
	
	@Select("SELECT * FROM USER_TB where id = #{id}")
	User getUserById(long id);
	
	@Insert("insert into USER_TB(EMAIL,PASSWORD,FIRSTNAME,LASTNAME,ENABLED) "
			+ "values(#{email},#{password},#{firstName},#{lastName},#{enabled})")
	boolean InsertUser(User user);
	
	@Delete("Delete From USER_TB where id= #{id}")
	boolean deleteUser(User user);
	
	
	
	
     


}
