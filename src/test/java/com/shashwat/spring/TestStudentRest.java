package com.shashwat.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.shashwat.spring.controller.URIConstantsStudentRest;
import com.shashwat.spring.model.Student;

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

	private static void testCreateStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = new Student();
		student.setId(1);
		student.setName("Shashwat");
		Student response = restTemplate.postForObject(SERVER_ADDR + URIConstantsStudentRest.CREATE_STUDENT,
				student, Student.class);
		
		printData(response);
	}
	
	public static void printData(Student student){
        System.out.println("ID = " + student.getId() + " ,Name = " + student.getName() 
        		+ " ,JoiningDate = "+ student.getJoiningDate());
    }
	
	private static void testGetStudent() {
		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject(SERVER_ADDR + "/rest/student/1", Student.class);
		printData(student);
	}

}
