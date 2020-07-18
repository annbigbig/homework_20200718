<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h1>MD5 hash測試</h1>
    <form action="hashServlet" method="post">
      原字串: <input type="text" name="original" size="20"><br>
      <input type="submit" value="產生MD5 Hash" />
    </form>
    
    <h1>
    <% 
       String hash = request.getParameter("hash");
       if(hash!=null){
    	out.println(hash);
       }
    %>
    </h1>
</body>
</html>