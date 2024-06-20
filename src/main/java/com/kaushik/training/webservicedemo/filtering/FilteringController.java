package com.kaushik.training.webservicedemo.filtering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean filtering() {

		return new SomeBean("Charles", "Max", "Lewis");

	}

	@GetMapping("/filteringList")
	public List<SomeBean> filteringList() {

		return Arrays.asList(new SomeBean("Charles", "Max", "Lewis"), new SomeBean("Carlos", "Sergio", "George"));

	}

	@GetMapping("/dynamicFiltering")
	public MappingJacksonValue DynamicFiltering() {

		SomeBean someBean = new SomeBean("Charles", "Max", "Lewis");

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;

	}
	
	@GetMapping("/dynamicFilteringList")
	public MappingJacksonValue dynamicFilteringList() {
		
		List<SomeBean> drivers = Arrays.asList(new SomeBean("Charles", "Max", "Lewis"),
											new SomeBean("Carlos", "Sergio", "George"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(drivers);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;

	}

}
