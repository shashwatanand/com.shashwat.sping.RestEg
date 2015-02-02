package com.shashwat.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shashwat.spring.model.Student;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	private Map<Integer, Student> data = new HashMap<Integer, Student>();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = URIConstantsStudentRest.DUMMY_STUDENT, method = RequestMethod.GET)
	public @ResponseBody Student getDummyStudent() {
		logger.info("Start getDummyStudent method");
		int id = 100;
		Student student = new Student();
		student.setId(id);
		student.setName("Dummy");
		student.setJoiningDate(new Date());
		this.data.put(id, student);
		return student;
	}
	
	@RequestMapping(value = URIConstantsStudentRest.GET_STUDENT, method = RequestMethod.GET)
	public @ResponseBody Student getStudent(@PathVariable("id") int id) {
		logger.info("Start getStudent method where id is " + id);
		return this.data.get(id);
	}
	
	@RequestMapping(value = URIConstantsStudentRest.DELETE_STUDENT, method = RequestMethod.PUT)
	public @ResponseBody Student deleteStudent(@PathVariable("id") int id) {
		logger.info("Start deleteStudent where id is " + id);
        Student student = this.data.get(id);
        this.data.remove(student);
        return student;
	}
}
