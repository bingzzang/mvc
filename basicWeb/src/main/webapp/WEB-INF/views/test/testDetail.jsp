<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 상세</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#postButton").click(function(){
		var varTitle = $("#title").val();
		var varContent = $("#content").val();
		var varWriter = $("#writer").val();
		
		var jsonData = {
				title : varTitle,
				content : varContent,
				writer : varWriter
		};
		
		console.log(jsonData);
		
		
		$.ajax({
			type: "post",			//던지는 방법
			url: "/test/detail/post",		//던져질 url
			data: JSON.stringify(jsonData), //데이터를 json 포맷으로 만들어줌	//던질 데이터
			contentType: "application/json; charset=UTF-8",		//던지는 데이터의 타입
			success: function(result){					//성공했을 때
				if(result == "SUCCESS"){
					alert("전송 성공");
				}
			}
		});
		
	});
	
	$("#putButton").click(function(){
		
		var varTitle = $("#title").val();
		var varContent = $("#content").val();
		var varWriter = $("#writer").val();
		
		var jsonData = {
				title : varTitle,
				content : varContent,
				writer : varWriter
		};
		
		console.log(jsonData);
		
		$.ajax({
			type: "put",	
			url: "/test/detail/put",
			data: JSON.stringify(jsonData),
			contentType: "application/json; charset=UTF-8",	
			success: function(result){
				if(result == "SUCCESS"){
					alert("PUT전송 성공");
				}
			},
			error: function(error){
				alert("전송 실패");
			}
		});
	});
		
	$("#xmlButton").click(function(){
		
		var varTitle = $("#title").val();
		var varContent = $("#content").val();
		var varWriter = $("#writer").val();
		
		var makeData = "";
		makeData += "<TestBoard>";
		makeData += "<title>Good Day</title>";
		makeData += "<content>Good Weather</content>";
		makeData += "<writer>BING</writer>";
		makeData += "</TestBoard>";
		
		$.ajax({
			type: "post",	
			url: "/test/detail/xml",
			data: makeData,
			contentType: "application/xml; charset=UTF-8",	
			success: function(result){
				if(result == "SUCCESS"){
					alert("xml 성공");
				}
			},
			error: function(error){
				alert("전송 실패");
			}
		});
	});
});
	
</script>
</head>
<body>
<h1>여러가지 데이터 포맷을 전송하겠습니다.</h1>

제목 : <input type="text" id="title" name="title" value=""><br>
내용 : <input type="text" id="content" name="content" value=""><br>
작성자 : <input type="text" id="writer" name="writer" value=""><br>
<br>
<button id="postButton">Post전송</button>
<button id="putButton">Put전송</button>
<button id="xmlButton">Xml전송</button>
</body>
</html>