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
 	
 	//input : Review 객체 (단 건)
 	//output : int(성공된 행의 개수)
 	public int addReview(Review review) {
 		return reviewMapper.insertReview(review);
 	}
 	
 	public int addReviewAsField(
 			int storeId, String menu, String userName, 
 			Double point, String review) {
		
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
 	
 	//ex03
 	//input : id, review
 	//output : int 성공된 행의 개수
 	public int updateReviewById(int id, String review) {
 		return reviewMapper.updateReviewById(id, review);
 	}
 	
 	//ex04 delete
 	public void deleteReviewById(int id) {
 		reviewMapper.deleteReviewById(id);
 	}
 	
} 
