package com.example.demo.handler;

import java.util.Observable;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class RowHandler extends Observable implements ResultHandler{

	@Override
	public void handleResult(ResultContext resultContext) {
		// TODO Auto-generated method stub
		super.setChanged();
		super.notifyObservers(resultContext.getResultObject());
	}

}
