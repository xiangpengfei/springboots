package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.Emp;

@Mapper
public interface EmpMapper {
 public List<Emp> empInfo();
	
	
}
