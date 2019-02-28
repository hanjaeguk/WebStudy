package com.kokkok.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.PageContext;

import org.apache.jasper.tagplugins.jstl.core.Param;

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
			path = "/member/myMenu/myInfo/view.jsp";
			PageMove.redirect(request, response, path);

		} else if ("mvmywritelist".equals(act)) {
			path = "/member/myMenu/myWrite/mywritelist.jsp";
			PageMove.redirect(request, response, path);

		} else if ("mvmyreviewwishlist".equals(act)) {
			path = "/member/myMenu/myWish/reviewwishlist.jsp";
			PageMove.redirect(request, response, path);
		} else if ("mvmyschedulewishlist".equals(act)) {
			path = "/member/myMenu/myWish/schedulewishlist.jsp";
			PageMove.redirect(request, response, path);
		} else if ("mvidcheck".equals(act)) {
			path = "/member/join/idcheck.jsp";
			PageMove.redirect(request, response, path);
		} else if ("register".equals(act)) {

			MemberDto memberDto = new MemberDto();
			memberDto.setName(request.getParameter("username"));
			memberDto.setId(request.getParameter("userid"));
			memberDto.setPass(request.getParameter("userpass"));
			memberDto.setEmail(request.getParameter("useremail"));

			int cnt = memberService.register(memberDto);
			System.out.println(cnt);
			System.out.println(memberDto.getId() + memberDto.getEmail() + memberDto.getPass() + memberDto.getName());
			if (cnt != 0) {
				path = "/member/join/registerok.jsp";
				request.setAttribute("registerInfo", memberDto);
				PageMove.forward(request, response, path); // �뜝�럩�젧�솻洹ｏ옙�뜝�룞�삕 �뤆�룊�삕�뜝�럩二ф뤆�룊�삕�뜝�럥�뒍�뜝�럥�뵹�뜝�럥鍮띸뭐癒뀁삕 forward
			} else {
				path = "/member/join/registerfail.jsp";
				PageMove.redirect(request, response, path);
			}

		} else if ("login".equals(act)) {
			String id = request.getParameter("loginid");
			String pass = request.getParameter("loginpass");
			MemberDto memberDto = memberService.login(id, pass);
			if (memberDto != null) {// 嚥≪뮄�젃占쎌뵥 占쎈쭫占쎌뱽占쎈르
				System.out.println(memberDto.toString());
				////////////////////////// session 占쎄퐬占쎌젟/////////////////////////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				path = "/index.jsp";
			}else {
				path = "/member/join/register.jsp";
			}
			PageMove.redirect(request, response, path);
		} else if ("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null); 占쎈툧�넫�뿭占썼쳸�뫖苡�
//			session.removeAttribute("userInfo"); 占쎌뵬獄쏆꼷�읅占쎌뵥獄쎻뫖苡�
			session.invalidate();// 占쎄쉭占쎈�∽옙釉욑옙肉� 占쎌뿳占쎈뮉椰꾬옙 占쎈뼣占쎈뼄 筌욑옙占쎌뜖占쎌뵬
			PageMove.redirect(request, response, path);
			path = "/index.jsp";
			
		} else if ("mvidcheck".equals(act)) {
			path =  "/member/join/idcheck.jsp";
			PageMove.redirect(request, response, path);
		} else if ("idcheck".equals(act)) {
			String id = request.getParameter("checkid");
			int idCnt = memberService.idCheck(id);
			request.setAttribute("checkid", id);
			request.setAttribute("idCnt", idCnt);
			path =  "/member/join/idcheck.jsp";
			PageMove.forward(request, response, path);
		} else if ("mvmodify".equals(act)) {
			path = "/member/myMenu/myInfo/modify.jsp";
			PageMove.redirect(request, response, path);
			
		} else if ("mvdelete".equals(act)) {
			path = "/member/myMenu/myInfo/delete.jsp";
			PageMove.redirect(request, response, path);

		}else if ("".equals(act)) {

		}
		else {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODER);
		doGet(request, response);
	}

}
