package com.jdc.weekend.record;

public record StateWithDistrictCount(
		int id,
		String name,
		int districtCount
		) {
	
	public String show() {
		return "ID : %n , Name : %s , DistrictCount : %n".formatted(id,name,districtCount);
	}

}
