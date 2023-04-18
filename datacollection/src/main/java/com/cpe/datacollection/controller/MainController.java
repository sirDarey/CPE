package com.cpe.datacollection.controller;

import com.cpe.datacollection.model.Student;
import com.cpe.datacollection.service.StudentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;

	@GetMapping("/")
	public ModelAndView getStudents () {
		ModelAndView mav = new ModelAndView("students_list");
		List<Student> students = studentService.getStudents();
		mav.addObject("students", students);
		return mav;
	}

//	@RequestMapping("/get_student")
//	public ModelAndView getStudent (Student student, HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView("pages/get_student");
//		Student getStudent = studentService.getStudent(student.getId());
//		mav.addObject("get_student", getStudent);
//		req.getSession().setAttribute("updatedStatus", "0");
//		return mav;
//	}

    @RequestMapping("/new_student")
    public String new_student () {
        return "register";
    }

    @PostMapping("/register")
    public String addStudent (@ModelAttribute Student student, HttpSession session) {
        session.setAttribute("message", "Registration Successful");
        studentService.addStudent(student);
        return "redirect:/";
    }
}
