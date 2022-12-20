package com.example.demo.service;

import java.util.List;
import java.util.Observer;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.handler.RowHandler;
import com.example.demo.mapper.SalaryMapper;
import com.example.demo.model.SalaryModel;


@Service
public class SalaryService {
	
	@Autowired
	public SalaryMapper mapper;

	public List<SalaryModel> getSalaryOri(){
		return mapper.getSalaryOri();
	}

	public List<SalaryModel> getSalary(){
		return mapper.getSalary();
	}
	
	public void getAllSalary(Observer observer) {
		RowHandler resultHandler = new RowHandler();
		resultHandler.addObserver(observer);
		mapper.getAllSalary(resultHandler);
	}
	
}
