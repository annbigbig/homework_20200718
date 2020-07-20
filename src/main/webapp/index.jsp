<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h1>請輸入您的帳號和密碼</h1>
    <form action="loginServlet" method="post">
      帳號: <input type="text" name="account" size="20"><br>
      密碼：<input type="password" name="password" size="20">
      <input type="submit" value="登入" />
    </form>
    
    <h1>
    <% 
       String message = request.getParameter("message");
       if(message!=null){
    	out.println(message);
       }
    %>
    </h1>
</body>
</html>