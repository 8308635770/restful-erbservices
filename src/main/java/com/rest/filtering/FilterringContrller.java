package com.rest.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/filter")
public class FilterringContrller {
	
	@GetMapping("/filtering")
	public SomeBean getSomeBean() {
		return new SomeBean("v1","v2","v3");
//		return "srt";
	}
	
	@GetMapping("/filtering/dyanamic")
	public MappingJacksonValue getSomeBeanDyanamic() {
		SomeBean someBean= new SomeBean("v1","v2","v3");

		MappingJacksonValue  value=new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("exFilter",filter);
		value.setFilters(filters);
	
	return value;
	}


}
