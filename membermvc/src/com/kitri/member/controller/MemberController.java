package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.member.model.service.MemberService;
import com.kitri.member.model.service.MemberServiceImpl;
import com.kitri.util.PageMove;
import com.kitri.util.SiteConstance;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService;
	public void init() {
		memberService = new MemberServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		System.out.println("act ======"+act);
		
		String path = "/index.jsp";
		
		if("mvjoin".equals(act)) {
			PageMove.redirect(request, response, "/join/member.jsp");
		}else if("mvlogin".equals(act)){
			PageMove.redirect(request, response, "/login/login.jsp");
		}else if("mvidcheck".equals(act)) {
			PageMove.redirect(request, response, "/join/idcheck.jsp");
		}else if("idcheck".equals(act)) {
			String id = request.getParameter("id");
			int idCnt = memberService.idCheck(id);
			
			request.setAttribute("id", id);
			request.setAttribute("idCnt", idCnt);
		
			PageMove.forward(request, response,"/join/idcheck.jsp");
			
		}else if("mvzip".equals(act)) {
			PageMove.redirect(request, response, "/join/zipsearch.jsp");
		}else if("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			List<ZipCodeDto> list = memberService.zipSearch(doro);
			
			System.out.println("검색 갯수:"+list.size());
			
			request.setAttribute("ziplist", list);
			request.setAttribute("doro", doro);
			
			PageMove.forward(request, response,"/join/zipsearch.jsp");

//																//어차피 내꺼 안이라서 제일 앞에 root필요 없다.
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/join/zipsearch.jsp");
//			dispatcher.forward(request, response); // 값을 보내줌!
			
									//url이라 풀 경로가 필요!(포워딩이랑 이거 하나만 써야함)
//			response.sendRedirect(root + "/join/zipsearch.jsp"); //url만 보내줌!
		}else if("register".equals(act)){
	
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmailId(request.getParameter("emailid"));
			memberDetailDto.setEmailDomain(request.getParameter("emaildomain"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			memberDetailDto.setZipCode(request.getParameter("zipcode"));
			memberDetailDto.setAddress(request.getParameter("address"));
			memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
			System.out.println(memberDetailDto);
			
			int cnt = memberService.register(memberDetailDto);
			if(cnt != 0) {
				path ="/join/registerok.jsp";
				request.setAttribute("registerInfo", memberDetailDto);
				PageMove.forward(request, response, path); // 정보를 가져가야되니깐 forward
			}else {
				path ="/join/registerfail.jsp";
				PageMove.redirect(request, response, path);
			}
//			path = cnt != 0 ? "/join/registerok.jsp" : "/join/registerfail.jsp";
			
			
		}else if("mvmodify".equals(act)){ //회원수정페이지로 이동
			HttpSession session = request.getSession();
			MemberDetailDto memberDetailDto = memberService.getMember(((MemberDto)session.getAttribute("userInfo")).getId());
			path = "/join/modify.jsp";
			PageMove.redirect(request, response, path);
			
		}else if("modify".equals(act)){
			
			PageMove.redirect(request, response, "/login/modifyok.jsp");
			
		}else if("delete".equals(act)){
			PageMove.redirect(request, response, "/login/login.jsp");
		}else if("login".equals(act)){
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");	
			MemberDto memberDto = memberService.login(id, pass);
			
			if(memberDto != null) {
				////////////////////////// session 설정 //////////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto); // 세션은 redirect던 forward던 상관X
																// 세션이 true 인곳에서는!
				
				////////////////////////// cookie 설정 //////////////////////////
				String idsave = request.getParameter("idsave");
				if("idsave".equals(idsave)) {
					Cookie cookie = new Cookie("nid_sid", id);
					cookie.setPath(root);
					cookie.setMaxAge(60 * 60 * 24 * 365 * 100);
					response.addCookie(cookie);			
					
					//쿠키 여러개 만들기
//					Cookie cookie1 = new Cookie("nid_sid", id);
//					cookie1.setPath(root);
//					cookie1.setMaxAge(60 * 60 * 24 * 365 * 100);
//					response.addCookie(cookie1);	
//					
//					Cookie cookie2 = new Cookie("nid_sid", id);
//					cookie2.setPath(root);
//					cookie2.setMaxAge(60 * 60 * 24 * 365 * 100);
//					response.addCookie(cookie2);	
				}else {
					Cookie cookies[] = request.getCookies();

					if(cookies != null){
						for(Cookie cookie : cookies){
							if(cookie.getName().equals("nid_sid")){
								cookie.setPath(root);
								cookie.setMaxAge(0); // 만료날짜 0초! 바로 지워버려라!
								response.addCookie(cookie); //response에 담아라
								break;
							}
						}
					}
				}
				
				path = "/login/loginok.jsp";
			}else {
				path = "/login/loginfail.jsp";

			}
			
			
//			path = memberDto != null ? "/login/loginok.jsp" : "/login/loginfail.jsp";
//			request.setAttribute("userInfo", memberDto);
			
			PageMove.forward(request, response,path);
			
		}else if("logout".equals(act)){
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null);
//			session.removeAttribute(name);
			session.invalidate(); // session안에 있는거 싹다 지워버려라!
			PageMove.redirect(request, response, "/login/loginok.jsp");
			
		}else if("mail".equals(act)){
			PageMove.redirect(request, response, "/mail/list.jsp");
//			PageMove.forward(request, response, "/mail/list.jsp");
		}
		
		
		else {
			PageMove.redirect(request, response, path);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.CHARSET);
		doGet(request,response);
	}

}


/*
 * Session & Cookie
 * 1.session : HttpSession	Server  Object(메모리할당)
 * HttpSession session = request.getSession(); // 세션 생성
 * session.setAttribute("name",object);
 * 
 * Object = obj = request.getAttribute("name");
 * request.removeAttribute("name");
 * 
 * 2.cookie  : Cookie			Client  txt(물리적인파일)
 * 
 * Cookie cookie = new cookie("name","value");
 * cookie.setDomain("domain");
 * cookie.Path("path");
 * cookie.setMaxAge(second);
 * 
 * */















