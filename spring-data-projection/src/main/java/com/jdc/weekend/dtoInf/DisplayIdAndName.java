package com.jdc.weekend.dtoInf;

import com.jdc.weekend.entity.State.Type;

public interface DisplayIdAndName {

	int getId();
	String getName();
	Type getType();
	
	default String getDisplayName() {
		return "%s %s".formatted(getName(),getType());
	}
	
}
