package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController //@Controller + ResponseBody
public class Lesson02Ex01RestController {
	
	@Autowired //DI(spring bean을 주입)
	private UsedGoodsBO usedGoodsBO;
	
	//요청 URL : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	//테이블의 1개의 행을 객체에 담아서모든 객체를 나타내기 위해 List로 작성 
	public List<UsedGoods> ex01() { //list = 여러개의 행 
		//DB연동
		//usedGoods : 단건 , usedGoodsList : 여러행
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		//응답
		return usedGoodsList; //JSON - Response Body 출력
	}
	
}
