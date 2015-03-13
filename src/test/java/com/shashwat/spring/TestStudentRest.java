package com.shashwat.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.shashwat.spring.controller.URIConstantsStudentRest;

public class TestStudentRest {
	
	private static final String SERVER_ADDR = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void testGetAllStudents() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> list = restTemplate.getForObject(SERVER_ADDR + URIConstantsStudentRest.GET_ALL_STUDENTS, List.class);
		System.out.println(list.size());
        for(LinkedHashMap map : list){
            System.out.println("ID = "+ map.get("id") + " ,Name = " + map.get("name") + " ,CreatedDate = "+ map.get("createdDate"));;
        }
	}

}
