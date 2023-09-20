package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController //@Controller + ResponseBody
public class Lesson02Ex01RestController {
	
	//요청 URL : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() { //list = 여러개의 행 
		//응답 내려주기 / DB연동
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList; //JSON
	}
	
}
