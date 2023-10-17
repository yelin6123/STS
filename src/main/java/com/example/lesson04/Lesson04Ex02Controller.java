package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class Lesson04Ex02Controller {
	
	@Autowired
	private StudentBO studentBO;
	
	//url: http://localhost/lesson04/ex02/add-student-view
	//학생 정보 추가 화면
	@GetMapping("add-student-view")
	public String addStudentView () {
		return "lesson04/addStudent";
	}
	
	//가입 처리 후 가입된 사람 정보 뿌려주기
	//url: http://localhost/lesson04/ex02/add-student
	@PostMapping("add-student")
	public String addStudent(
			@ModelAttribute Student student, //jsp의 name명과 domain의 필드명이 동일하다면 자동으로 연동 됨 > 태그의 name속성과 일치하는 필드에 매핑된다.
			//id와 createdAt, updatedAt의 경우 : id > 0부터 시작 /createdAt, updateAt은 null로 됨
			Model model) {
		
		// DB insert
		studentBO.addStudent(student); //자동으로 id가 채워짐 => 주소 덕분!
		
		//DB select => 방금 가입된 사람
		//int id = student.getId();
		Student latestStudent = studentBO.getStudentById(student.getId());
		model.addAttribute("student", latestStudent);

		return "lesson04/afteraddStudent";
	}
	
}


















