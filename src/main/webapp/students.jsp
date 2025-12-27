<%@ page import="java.util.List" %>

<table border="1">
<tr><th>Name</th><th>Email</th><th>Year</th></tr>

<%
List<String[]> students = (List<String[]>) request.getAttribute("students");
for (String[] s : students) {
%>
<tr>
  <td><%= s[0] %></td>
  <td><%= s[1] %></td>
  <td><%= s[2] %></td>
</tr>
<% } %>

</table>
