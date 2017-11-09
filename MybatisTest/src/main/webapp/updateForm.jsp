<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.spring.mybatis.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
List<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("memberList");
MemberVO u_member = (MemberVO)request.getAttribute("member");
%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function res() {
		location.href = "list.do";
	}
	function update(id2, name2, email2, phone2) {
		var id = id2;
		var name = name2;
		var email = email2;
		var phone = phone2;
		
		location.href = "update.do?id="+id+"&name="+name+"&email="+email+"&phone="+phone;
	}
	function del(id) {
		location.href = "delete.do?id="+id;
	}
</script>
</head>
<body>
	<form method = "post" action = "insert.do">
		<table border = "1" align = "center">
			<tr>
				<td>
					아이디
				</td>
				<td>
					이름
				</td>
				<td>
					이메일
				</td>
				<td>
					전화번호
				</td>
				<td align = "center">
					<input type = "button" value = "리스트" onclick = "res()"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type = "text" name = "id" id = "id"/>
				</td>
				<td>
					<input type = "text" name = "name" id = "name"/>
				</td>
				<td>
					<input type = "text" name = "email" id = "email"/>
				</td>
				<td>
					<input type = "text" name = "phone" id = "phone"/>
				</td>
				<td align = "center">
					<input type = "submit" value = "추가"/>
				</td>
			</tr>
			<%
				for(int i = 0; i < memberList.size(); i++) {
					MemberVO member = memberList.get(i);
					if(member.getId().equals(u_member.getId())) {
			%>
			<tr>
				<td>
					<%=u_member.getId() %>
				</td>
				<td>
					<input type = "text" name = "name2" id = "name2" value = "<%=u_member.getName()%>"/>
				</td>
				<td>
					<input type = "text" name = "email2" id = "email2" value = "<%=u_member.getEmail()%>"/>
				</td>
				<td>
					<input type = "text" name = "phone2" id = "phone2"value = "<%=u_member.getPhone()%>"/>
				</td>
				<td>
					<input type = "button" value = "수정" onclick = "update('<%=u_member.getId() %>',name2.value, email2.value, phone2.value)">
					<input type = "button" value = "삭제" onclick = "del('<%=u_member.getId() %>')"/>
				</td>
			</tr>
			<%			
					} else {
				
			%>
			<tr>
				<td>
					<%=member.getId() %>
				</td>
				<td>
					<%=member.getName() %>
				</td>
				<td>
					<%=member.getEmail() %>
				</td>
				<td>
					<%=member.getPhone() %>
				</td>
				<td>
					<input type = "button" value = "수정" onclick = "updateForm('<%=member.getId() %>')">
					<input type = "button" value = "삭제" onclick = "del('<%=member.getId() %>')">
				</td>
			</tr>
			<%
					}
				}
			%>
		</table>
		</form>
</body>
</html>