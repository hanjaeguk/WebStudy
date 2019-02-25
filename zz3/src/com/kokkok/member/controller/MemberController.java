package com.kokkok.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.kokkok.member.model.MemberDto;
import com.kokkok.member.model.service.MemberService;
import com.kokkok.member.model.service.MemberServiceImpl;
import com.kokkok.util.*;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService;

	public void init() {
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");

		String path = "/index.jsp";
		if ("mvregister".equals(act)) {
			path = "/member/join/register.jsp";
			PageMove.redirect(request, response, path);

		} else if ("mvmyinfo".equals(act)) {
			path = "/member/myMenu/myInfo/list.jsp";
			PageMove.redirect(request, response, path);

		} else if ("mvwritelist".equals(act)) {
			path = "/member/myMenu/myWrite/list.jsp";
			PageMove.redirect(request, response, path);

		} else if ("mvwishlist".equals(act)) {
			path = "/member/myMenu/myWish/list.jsp";
			PageMove.redirect(request, response, path);
		} else if ("mvidcheck".equals(act)) {
			path = "/member/join/idcheck.jsp";
			PageMove.redirect(request, response, path);
		} else if ("register".equals(act)) {

			MemberDto memberDto = new MemberDto();
			memberDto.setName(request.getParameter("name"));
			memberDto.setId(request.getParameter("id"));
			memberDto.setPass(request.getParameter("pass"));
			memberDto.setEmail(request.getParameter("email"));

			int cnt = memberService.register(memberDto);
			System.out.println(cnt);
			System.out.println(memberDto.getId() + memberDto.getEmail() + memberDto.getPass() + memberDto.getName());
			if (cnt != 0) {
				path = "/member/join/registerok.jsp";
				request.setAttribute("registerInfo", memberDto);
				PageMove.forward(request, response, path); // �젙蹂대�� 媛��졇媛��빞�릺�땲源� forward
			} else {
				path = "/member/join/registerfail.jsp";
				PageMove.redirect(request, response, path);
			}

		} else if ("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			MemberDto memberDto = memberService.login(id, pass);
			System.out.println(memberDto.toString());
			if (memberDto != null) {// 로그인 됬을때
				////////////////////////// session 설정/////////////////////////////////////////
				System.out.println(memberDto.toString());
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				path = "/index.jsp";
			}else {
				path = "/member/join/register.jsp";
			}
			PageMove.forward(request, response,path);
		} else if ("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null); 안좋은방법
//			session.removeAttribute("userInfo"); 일반적인방법
			session.invalidate();// 세션안에 있는거 싹다 지워라
			PageMove.redirect(request, response, path);
			path = "/index.jsp";
			
		} else if ("mvmemberslist".equals(act)) {
			path = "/admin/members/list.jsp";
			PageMove.redirect(request, response, path);

		} else if ("".equals(act)) {

		} else {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}
