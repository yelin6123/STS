package com.example.lesson02.bo;

import org.springframework.stereotype.Service;

@Service //spring bean
public class UsedGoodsBO {
	//input(Controller로부터 요청 받음) : param가 없음 - 다 받을 수 있음  
	//output(Controller로한테 돌려줌) : param - 요청 받은 것을 돌려줌 List<UsedGoods>
	//BO에서 메소드명 규칙이 있음 
	public List<UsedGoods> getUsedGoodsList() { //input자리 비어있음 
		
	}
}
