package com.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficServiceImpl implements TrafficService{

	@Override
	public String getTraffic() {
		// simulate delay
		
		try {
			TimeUnit.SECONDS.sleep(5);	
		} 
		
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// return
		
		return "Expect heavy traffic this morning";
	}

	@Override
	public String getTraffic(boolean tripWire) {
	
		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		
		return getTraffic();
	}

}
