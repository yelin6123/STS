package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	
	//input(BO-Service) : x
	//output(BO-Service 결과 돌려줌) : List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
	//인터페이스이기 때문에 중괄호 없이 메소드 뼈대만 만들고 끝임
	//mybatis가 이어줌 - DB 쿼리문을 xml이라는 파일에 지정해서 Select문을 만듬
	//selectUsedGoodsList(); 에서 맵핑을 해서 연결됨 (xml과 연결됨)
}