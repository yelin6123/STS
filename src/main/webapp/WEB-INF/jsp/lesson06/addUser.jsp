<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 (slim 제거) -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<%-- <form method="post" action="/lesson06/ex01/add-user"> --%>
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<%--  <input type="submit" class="btn btn-success" value="추가"> --%>
			<%-- ★★★ AJAX 통신일 때는 반드시 button 타입으로 지정한다!!! --%>
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		<%-- </form> --%>
	</div>
	<script>
		$(document).ready(function(){
			/* //1) jquery submit 기능 이용하기 (form태그)
			$("form").on("submit", function(e) { //e : 이벤트
				e.preventDefault(); //기본적으로 폼태그 동작을 하는걸 막음
				//alert("폼 태그 동작")
				
				//validation check
				let name = $("#name").val().trim();
				if(name == "") {
					alert("이름을 입력하세요");
					return false; //submit 안하고 그 상태로 머물러 있어야 함 (중요!!!!)
				} 
				
				let yyyymmdd = $("#yyyymmdd").val().trim(); //val = value trim = 앞뒤 공백 제거
				if(yyyymmdd.length < 1) {
					alert("생년월일 입력해주세요")
					return false; //submit 안함
				}
				
				let email = $("#email").val().trim();
				if(!email) { //!email : 값이 안채워져 있다 
					alert("이메일을 입력하세요")
					return false;
				}
				//여기까지 도달하면 submit수행 
			}); */
			
			// 2) jquery의 AJAX 통신 이용하기 
			$('#joinBtn').on('click', function(){
				//alert("버튼 클릭");
				
				//validation check
				let name = $("#name").val().trim();
				if(name == "") {
					alert("이름을 입력하세요");
					return; //버튼 클릭이라서 return으로 돌려주면 돼 
				} 
				
				let yyyymmdd = $("#yyyymmdd").val().trim(); //val = value trim = 앞뒤 공백 제거
				if(yyyymmdd.length < 1) {
					alert("생년월일 입력해주세요")
					return; 
				}
				
				let email = $("#email").val().trim();
				if(!email) { 
					alert("이메일을 입력하세요")
					return;
				}
				
				let introduce = $("#introduce").val();

				//requestParam 으로 잘 들고 왔는지 
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				
				//alert("AJAX 수행")
				
				// AJAX 서버 요청
				$.ajax({ //$ : 제이쿼리 / 리퀘스트, 리스판스 다있음 -> 브라우저 처럼  
					//request
					type:"POST" //type생략해도 돼 (기본적으로 get으로 쓰임) / type 은 무조건 소문자로 써야함
					, url:"/lesson06/ex01/add-user" //action과 동일, /붙이는 절대경로로 !
					, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} //requestParam형식,{JSON String으로 보내기} {key(DB 컬럼명)):value(변수명-console.log에서 받아온것)}
					
					//response
					//call back 함수
					, success:function(data) { //data: response 결과 응답 (위(request)의 data와 아무런 상관 없음)
						//data 의 응답값은 String 이다 !!!!!
						//서버를 처리 하고 에러가 없을 때 수행 됨
						//alert(data);
						if(data == "성공") {
							location.href="/lesson06/ex01/get-latest-user"; //다른 페이지일 경우 http://하세용
						}
					}  
					, complete:function(data) {
						//성공이든 실패든 무조건 불려짐 => 잘 안씀 !
						alert(data);
					}
					, error:function(request, status, error) {
						//서버를 처리하고 에러, 실패했을 때 수행 됨 
						alert(request); //관례적 , 400대 에러, 객체 띄어짐 
						alert(status); //500대 에러,
						alert(error); // 에러메세지 띄어짐 
					}
				}); 
				
				
			});
			
			
		});
	</script>	
</body>
</html>



