<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
		<!-- ���ε�� ���� -->
		<button id="next">�Ѿ��</button>
		
		<script>
			$("#next").on("click",function(){
				$(location).attr("href","detail.adboard");
			})
		</script>
	
</body>
</html>