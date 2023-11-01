package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	//mybatis로 호출할 때 : mapper => xml
	@Autowired
	private StudentMapper studentMapper; //mybatis
	
	//JPA로 호출할 때 : 레파짓토리 => method
	@Autowired
	private StudentRepository studentRepository;
	
	
	//Mybatis 문법
	//input : student 객체
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	//JPA 문법
	//input:파라미터들		output:StudentEntity 그대로 보내줌 
	public StudentEntity addStudent (String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder() //bilder가 안나오면 lombok이 안된것
				.name(name) //parameter에서 받아온 name을 넣겠다는 뜻
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)  
				.createdAt(ZonedDateTime.now()) //utc세계 시간 ZonedDateTime //created, updated는 안넣어도 자동으로 들어감 : @UpdateTimestamp 때문
				.build();
		
		return studentRepository.save(student); 
	}
	
	//lesson07/ex02
	//input : id, dreamJob output : 변경된 StudentEntity 
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null); 
		//.findById(id)로 id를 조회하게 될 경우 id가 있을수도 있고, 없을 수도 있음 그러므로 옵셔너리(orElse)라는 애로 묶어줘서 없다면 null, 있다면 조회함
		//null이 아닐 때만 DB에 업데이트 하겠다.
		if(student != null) {
			//기존 값은 유지하고 세팅된 일부의 값만 변경 (dreamJob만 변경) => toBuilder 
			//Entity쪽으로 가서 @Builder(toBuilder = true)로 변경함. 수정 허용 
			student = student.toBuilder() //기존값 유지
				.dreamJob(dreamJob)
				.build();
			
			//update
			student = studentRepository.save(student); //db에 update 후 다시 셀렉트 된 결과
		}
		
		return student; //null 또는 변경된(성공된) 데이터
	}

	//delete
	//input : 삭제할 id output : x
	public void deleteStudentById(int id) {
		//방법1 
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if(student != null) {
//			studentRepository.delete(student);
//		}
		
		//방법2 - 옵셔널 객체 사용법
		Optional<StudentEntity> studentOptional =  studentRepository.findById(id);
		//if문을 Optional로 만듬 :  null이 아니라면(ifPresent) studentEntity를 s라는 이름으로 넘겨서 삭제 요청(StudentRepository.delete)한다. / 만약 null이라면 수행안됨!
		//-> 람다식 : 요즘...세련된 문법이라 했나..?ㅎ
		studentOptional.ifPresent(s -> studentRepository.delete(s)); 
		   
	}
	
 }









