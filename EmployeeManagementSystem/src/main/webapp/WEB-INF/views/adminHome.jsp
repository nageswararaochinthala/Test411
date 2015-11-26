<%@page isELIgnored="false" %>
<html>
<head><h1 align="center">AdminHome</h1></head>
<body>
${status}

<h4><a href="changePassword.do?adminId=<%= request.getParameter("adminId") %>" >Change Password?</a></h4>
</body>
</html>