<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.util.*,com.kitri.member.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = new MemberDto(); 
memberDto.setId("Hanjaeguk22");
memberDto.setName("한재국");
memberDto.setEmailid("asdfas");
memberDto.setEmaildomain("naver.com");

session.setAttribute("userInfo", memberDto);

PageMove.redirect(request, response, "/adminboard?act=boardmenu");
%>    
