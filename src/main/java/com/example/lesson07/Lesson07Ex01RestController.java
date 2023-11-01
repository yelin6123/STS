package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	
	//C U D
	
	// C : creat, insert
	@GetMapping("/1")
	//DTO 를 Entity 로 사용함 (Entity : DB에서 가져온 다음 가공되지 않은 원본 자체) - jpa에서 사용 할 때 DTO -> Entity라고 사용
	public StudentEntity create() {
		//BO한테 `new_student`테이블 colum에 들어갈 내용 요청
		String name = "신보람";
		String phoneNumber = "010-1111-5222";
		String email = "sbr@kakao.com";
		String dreamJob = "개발자";
		
		//insert후 select도 할 수 있기 때문에 지금 들어간 id값도 사용할 수 있다. getId();로 얻어 낼 수 있음
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	//U : update
	@GetMapping("/2")
	public StudentEntity update() {
		//id:4 dreamJob을 변경
		//JSON으로 응답
		return studentBO.updateStudentDreamJobById(4, "디자이너") ;
	
	}
	
	//D : delete
	@GetMapping("/3")
	public String delete() {
		//id:8
		studentBO.deleteStudentById(4);
		return "삭제 완료";
		
	}
	
	
 		
}
