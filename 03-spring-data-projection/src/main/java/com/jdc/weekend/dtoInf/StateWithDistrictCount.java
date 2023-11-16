package com.jdc.weekend.dtoInf;

public interface StateWithDistrictCount {

	int getId();
	String getName();
	int getDistrictCount();
	
	default void show() {
		System.out.printf("ID : %2d ,Name : %-12s ,DistrictCount : %d%n",
				getId(),getName(),getDistrictCount());
	}
	
}
