package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;


@RequestMapping("/lesson04/ex01")
@Controller //JSP로 보낼 때는 @ResponseBody가 없어야 한다. 
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 페이지
	// http://localhost/lesson04/ex01/sign-up-view
	//@RequestMapping("/sign-up-view")
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET)
	public String signUpView() {
		return "lesson04/signUp"; // jsp view 경로
	}
	
	//회원가입 수행(DB에 insert) 후 결과 페이지로 이동
	// http://localhost/lesson04/ex01/sign-up
	@PostMapping("/sign-up") //GetMapping 또는 PostMapping 이 있음... 
	public String signUP(
			@RequestParam("name") String name, //signUp.jsp에 있는 각각의 파라미터의 name="@@@" 과 동일하게 맞춰주기~! 
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required=false) String email,
			@RequestParam(value = "introduce", required=false) String introduce) { 
		
		//DB Insert (`new_user` 테이블에 계속 쌓기) => bo, mapper패키지 생성
		userBO.addUser(name, yyyymmdd, email, introduce);
		//결과값을 안돌려줌 -> 다른 페이지로 이동 (responsebody가 없어서 그럼^^) 
		
		return "lesson04/signUpResult"; //signUpResult.jsp 페이지로 이동
	}
	
	//최신 가입자 한명 가져오는 페이지 
	// http://localhost/lesson04/ex01/get-latest-user-view
	@GetMapping("/get-latest-user-view")
	public String getLatestUserView(Model model) {
		//DB에서 select 조회하는 내용 (단건 -> list가 아님) 
		//1. 단건을 담을 수 있는 객체를 생성하기 위해 도메인 생성 필요
		User user = userBO.getLatestUser(); //객체에 최신 가입자 1명의 데이터가 담김!
		model.addAttribute("result", user); //model에 객체 내용이 담김 
		model.addAttribute("title", "최신 유저 정보");
		
		// MVC
		// View(jsp) - Model(date) - Controller(server)
		return "lesson04/getLatestUser"; //결과 jsp 주소 경로 
	}
 }












