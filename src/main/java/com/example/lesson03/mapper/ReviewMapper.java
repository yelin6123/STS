package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	public Review selectReview(int id);
	
	//단건으로 @Param 생략
	//return int (MyBatis가 성공된 행의 개수를 리턴해준다)
	//[참고]int => void 로 바꿀 수 있는데, 이 경우 리턴이 안됨
	public int insertReview(Review review); 
	
	// 파라미터 2개 이상이면 map으로 만든다(@Param)
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);

	public int deleteReviewById(int id);
	
 	}

	
