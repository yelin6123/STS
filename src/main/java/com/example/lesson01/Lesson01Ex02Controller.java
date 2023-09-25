package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //jsp를 뿌릴 때는 @ResponseBody가 없는 @Controller를 사용해야함
public class Lesson01Ex02Controller {

		//요청URL : http://localhost/lesson01/ex02
		@RequestMapping("/lesson01/ex02") //요청 주소 
		public String ex02() { //jsp 를 뿌릴 때는 무조건 String으로 해야함
			//jsp경로를 리턴한다. (webapp 이후부터 작성해야함)
			//return "/WEB-INF/jsp/lesson01/ex02.jsp";
			//		  /WEB-INF/jsp/ 	중간경로	.jsp
			return "lesson01/ex02"; //jsp view 경로와 이름, 응답을 주는주소
			
			
		}	
}
