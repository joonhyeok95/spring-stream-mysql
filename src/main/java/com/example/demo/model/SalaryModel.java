package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SalaryModel {
	private int emp_no;
	private int salary;
	private String from_date;
	private String to_date;
}
