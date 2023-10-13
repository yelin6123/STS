package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController
public class Lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	//http://localhost/lesson03/ex03?id=9&review=와퍼는맛나요맛나
	@RequestMapping("/lesson03/ex03")
	
	//하나의 행을 업데이트 치는거 배울거임 => 어느 행의 어느 값을 바꾼다! (특정 아이디의리 내용 바꾸기)
	 public String ex03(
			 @RequestParam("id") int id,
			 @RequestParam("review") String review) {
		int rowCount = reviewBO.updateReviewById(id, review);
		return "변경 완료 :" + rowCount; //String=> HTML
	}	
 }
