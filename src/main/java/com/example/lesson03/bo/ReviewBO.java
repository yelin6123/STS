package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired //spring bean 가져오기
	private ReviewMapper reviewMapper; 
	
	
	//input : id = 5
	//output : Controller한테 Review (단건) 주기
 	public Review getReview(int id) {
 		return reviewMapper.selectReview(id); 
 	}
} 
