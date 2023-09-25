package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

//서비스를 한다는 내용의 spring bean을 어노테이션 함
@Service
//DB와 가까워져서 BO옆에 데이터의 이름을 붙임
public class UsedGoodsBO {
	
	@Autowired //spring bean(객체) 가져오는 것 - DI(Dependency Injection)
	private UsedGoodsMapper usedGoodsMapper;
	
	
	//input(Controller로 부터 요청 받음) : param가 없음 - 다 받을 수 있음  
	//output(Controller한테 돌려줌) : param - 요청 받은 것을 돌려줌 : List<UsedGoods>
	//BO에서 메소드명 규칙이 있음 
		//ㄴ controller 입장에서 얻어낸다고 생각해서 get을 붙이기
	public List<UsedGoods> getUsedGoodsList() { //input자리 비어있음 
		return usedGoodsMapper.selectUsedGoodsList();		
	}
}
