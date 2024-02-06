package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tech.dto.Student;
import com.tech.service.StudentService;

@Controller
public class StudentController {

	public StudentController() {
		System.out.println("StudentController constructor");
	}

	@Autowired
	StudentService studentService;

	@RequestMapping("/create")
	public ModelAndView createStudent(@RequestParam("fname") String fname, @RequestParam("lname") String lname) {

		System.out.println("inside studentService createStudent method");
		System.out.println(fname + "--" + lname);

		int record = studentService.createStudent(fname, lname);
		System.out.println(record);

		if (record > 0) {
			ModelAndView mav = new ModelAndView("create-succes");
			return mav;
		}
		return null;
	}

	@RequestMapping("/getAll")
	public ModelAndView getAllStudent() {
		System.out.println("inside StudentController getAllStudent method");

		List<Student> stdlist = studentService.getAllStudent();
		System.out.println(stdlist);

		ModelAndView mav = new ModelAndView("getAll");
		mav.addObject("STDLIST", stdlist);
		return mav;
	}

	@RequestMapping("/deleteStudent1")
	public ModelAndView deleteStudent(@RequestParam("id") int id) {
		System.out.println("inside StudentController deleteStudent method" + id);

		studentService.deleteStudent(id);
		List<Student> stdlist = studentService.getAllStudent();

		ModelAndView mav = new ModelAndView("getAll");
		mav.addObject("STDLIST", stdlist);
		return mav;
	}
	
	@RequestMapping("/editStudent")
	public ModelAndView getStudentByid(@RequestParam("id")int id) {
		
		System.out.println("inside StudentController getStudentByid");
		Student student= studentService.getStudentByid(id);
		ModelAndView mav=new ModelAndView("editStudent");
		
		mav.addObject("STUDENT",student);
		return mav;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam("fname")String fname,
			@RequestParam("lname") String lname,
			@RequestParam("id")int id) {
		System.out.println("inside StudentController updateStudent");
		
		System.out.println(fname+"-"+lname+"-"+id);
		
		Student student=new Student();
		student.setFname(fname);
		student.setLname(lname);
		student.setId(id);
		
		studentService.updateStudent(student);
		
		List<Student> stdlist=studentService.getAllStudent();
		
		ModelAndView mav=new ModelAndView("getAll");
		mav.addObject("STDLIST",stdlist);
		return mav;
	}

}
