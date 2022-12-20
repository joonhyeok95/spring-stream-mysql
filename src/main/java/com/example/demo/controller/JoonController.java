package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.example.demo.model.SalaryModel;
import com.example.demo.service.SalaryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class JoonController {

	@Autowired
	SalaryService salaryService;
	
	@GetMapping(value="/ori")
	private List<SalaryModel> salaryOri() {
		List<SalaryModel> salaryList = salaryService.getSalaryOri();
    	return salaryList;
	}
	@GetMapping(value="/sal")
	private List<SalaryModel> salary() {
		List<SalaryModel> salaryList = salaryService.getSalary();
    	return salaryList;
	}
	@GetMapping(value="/stream")
	private ResponseBodyEmitter stream() {
		// timeout 10분
		final ResponseBodyEmitter emitter = new ResponseBodyEmitter(600000L);

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			salaryService.getAllSalary((observer, args) -> {
					try {
						emitter.send(args.toString() + "\n");
					} catch (IOException e) {
						log.error("### Stream 방식으로 목록을 전달하던 중 에러 발생", e);
					}
				});
			emitter.complete();
		});
		return emitter;
	}
	
}
