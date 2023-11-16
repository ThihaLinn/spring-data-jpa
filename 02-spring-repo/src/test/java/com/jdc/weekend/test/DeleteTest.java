package com.jdc.weekend.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.weekend.config.JpaCongfiguration;
import com.jdc.weekend.entity.State;
import com.jdc.weekend.repo.StateRepo;

import net.bytebuddy.asm.Advice.Argument;

@SpringJUnitConfig(classes = JpaCongfiguration.class)

public class DeleteTest {

	@Autowired
	private StateRepo repo;

	@Disabled
	@ParameterizedTest
	@Sql(scripts = { "/save/init.sql", "/load-data.sql" })
	@CsvSource(delimiter = ',', value = "1,Ayeyarwady,Region,Pathein,South,14")
	void delete(int id, String name, String type, String Capital, String region, long remain) {

		var input = new State(id, name, type, Capital, region);

		repo.delete(input);

		assertThat(repo.count(), is(remain));

	}

	@Disabled
	@ParameterizedTest
	@CsvSource("1,14")
	void delete_by_id(int id, long remain) {

		repo.deleteById(id);

		assertThat(repo.count(), is(remain));
	}
	
	@Disabled
	@Test
    void delete_all() {
		repo.deleteAll();
		assertThat(repo.count(), is(0L));
	}
	
	@Disabled
	@Test
	void delete_all_by_batch() {
		repo.deleteAllInBatch();
		assertThat(repo.count(), is(0L));
	}
	
	@Disabled
	@ParameterizedTest
	@Sql(scripts = { "/save/init.sql", "/load-data.sql" })
	@CsvSource(value="1,4,5,6	11",delimiter = '\t')
	void delete_all_by_id(String ids, long remain) {

		var array = ids.split(",");
		 System.out.println(array);
		var input =Arrays.stream(array).map(a->Integer.parseInt(a)).toList();
		
		repo.deleteAllById(input);

		assertThat(repo.count(), is(remain));

	}
	
	@ParameterizedTest
	@Sql(scripts = { "/save/init.sql", "/load-data.sql" })
	@MethodSource("deleteAllByIdInBatch")
	void delete_all_by_id_in_batch(List<Integer> ids, long remain) {

	
		repo.deleteAllByIdInBatch(ids);

		assertThat(repo.count(), is(remain));

	}
	
	
	
	static Stream<Arguments> deleteAllByIdInBatch(){
		return Stream.of(
				Arguments.of(List.of(1,2,3,4), 11),
				Arguments.of(List.of(1,6),13)
				);
				
	}

}
