package com.jdc.weekend.record;

import com.jdc.weekend.entity.State.Type;

public record StateRecord(
		int id,
		String name,
		Type type
		) {

	public String getDisplayName() {
		return "%s %s".formatted(name,type);
	}
	
}
