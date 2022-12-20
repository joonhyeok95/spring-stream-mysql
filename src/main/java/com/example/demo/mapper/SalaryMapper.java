package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.ResultHandler;

import com.example.demo.model.SalaryModel;

//@Repository
@Mapper
public interface SalaryMapper {
	List<SalaryModel> getSalaryOri();
	List<SalaryModel> getSalary();
	void getAllSalary(ResultHandler handler);
}
