

<%@page import="com.hms.objects.User"%>
<%

//session.setAttribute("userid",null);
session.invalidate();
response.sendRedirect("login.jsp");
%>


