<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.kitri.member.model.*"%>

<memberlist>

<%
List<MemberDetailDto> list = (List<MemberDetailDto>) request.getAttribute("memberlist");
for(MemberDetailDto memberDetailDto : list){
%>
	<member>
		<userid><%=memberDetailDto.getId()%></userid>
		<username><%=memberDetailDto.getName()%></username>
		<email><%=memberDetailDto.getEmailId()%>@<%=memberDetailDto.getEmailDomain()%></email>
		<phone><%=memberDetailDto.getTel1()%>-<%=memberDetailDto.getTel2()%>-<%=memberDetailDto.getTel3()%></phone>
		<address><%=memberDetailDto.getAddress()%></address>
		<joindate><%=memberDetailDto.getAddressDetail()%></joindate>
	</member>
<%
}
%>
</memberlist>