<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h1>以用戶id查詢用戶</h1>
    <form action="jdbcServlet" method="post">
      用戶id（UUID）: <input type="text" name="id" size="40"><br>
      <input type="submit" value="查詢用戶" />
    </form>
    
    <h1>
    <% 
       String name = request.getParameter("name");
       if(name!=null){
    	out.println("查詢結果：" + name);
       }
    %>
    </h1>
</body>
</html>