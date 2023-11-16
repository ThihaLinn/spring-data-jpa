package com.jdc.weekend.dtoInf;

import org.springframework.beans.factory.annotation.Value;

public interface StateValue {

	int getId();
	String getName();
	@Value("#{target.name + ' '+target.type}")
	String getDisplayName();
	
}
