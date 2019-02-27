package com.kitri.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.kitri.member.model.*;
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
		String path = "/index.jsp";
		
		//이런식으로 하면 굳이 if(act!=null)을 안써도 되서 성능 향상업
		if("mvjoin".equals(act)) {
			PageMove.redirect(request, response, "/join/member.jsp");
			//response.sendRedirect(root+"/join/member.jsp");
		}else if("mvlogin".equals(act)) {
			PageMove.redirect(request, response, "/login/login.jsp");
			//response.sendRedirect(root+"/login/login.jsp");						
		}else if("mvidcheck".equals(act)) {
			PageMove.redirect(request, response,"/join/idcheck.jsp");
			//response.sendRedirect(root+"/join/idcheck.jsp");			
		}else if("idcheck".equals(act)) {	
			
			String id = request.getParameter("id");
			
			int cnt = memberService.idCheck(id);
			
			request.setAttribute("cnt", cnt);
			request.setAttribute("id", id);
			
			
			PageMove.forward(request, response,"/join/idcheck.jsp");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/join/idcheck.jsp");
//			dispatcher.forward(request, response);						
			
			
		}else if("mvzip".equals(act)) {
			
			PageMove.redirect(request, response,"/join/zipsearch.jsp");
			//response.sendRedirect(root+"/join/zipsearch.jsp");	
			
		}else if("zipsearch".equals(act)) {
			String doro = request.getParameter("doro");
			List<ZipCodeDto> list = memberService.zipSearch(doro);			
			
			//request에 저장하는거라고 생각하면됨 Map처럼
			request.setAttribute("ziplist", list);
			request.setAttribute("doro", doro);
			//path는 어차피 내 컴퓨터 경로에서 못나가기 때문에 root를 넣을 필요가 없다
			PageMove.forward(request, response,"/join/zipsearch.jsp");
			
			
		}else if("register".equals(act)) {		
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
	
		
		int cnt = memberService.register(memberDetailDto);		
		if(cnt!=0) {
		request.setAttribute("memberinfo",memberDetailDto);
		path = "/join/registerok.jsp";
		PageMove.forward(request, response,path);
		}else {
		path = "/join/registerfail.jsp";
		PageMove.redirect(request, response,path);
		}	
		
		//레지스트에 값 가져가서 레지스트ok에 값 넣는거 추가하기
		
		}else if("mvmodify".equals(act)) {			
			HttpSession session = request.getSession();						
			MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
			String id = memberDto.getId();			
			MemberDetailDto memberDetailDto = memberService.getMember(id);			
		  
			if(memberDetailDto!=null) {
			session.setAttribute("memberDetailDto", memberDetailDto);			
			path = "/modify.jsp";				
			}
			PageMove.forward(request, response,path);
			
			
		}else if("modify".equals(act)) {
			int cnt = 0;
			HttpSession session = request.getSession();
			MemberDetailDto memberDetailDto = (MemberDetailDto)session.getAttribute("memberDetailDto");
			cnt = memberService.modify(memberDetailDto);
			
			if(cnt!=0) {
				session.removeAttribute("memberDetailDto");
				session.setAttribute("memberDetailDto", memberDetailDto);
				path = "/join/modifyok.jsp";
			}	
			path = "/login/loginok.jsp";
			
			PageMove.forward(request, response, path);
		}else if("delete".equals(act)) {
			response.sendRedirect(root+"/.jsp");
		}else if("login".equals(act)) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
						
			MemberDto memberDto = memberService.login(id, pass);	
			
			
			if(memberDto!=null) {//로그인 됬을때
			//////////////////////////session 설정/////////////////////////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				
			///////////////////////// Cookie 설정 /////////////////////////////////////////
				String idsave = request.getParameter("idsave");
				if("idsave".equals(idsave)) {
				Cookie cookie = new Cookie("nid_sid",id);
				cookie.setPath(root);
				cookie.setMaxAge(60*60*24*365*100);
				response.addCookie(cookie);
				}else {//아이디저장 체크박스가 해제되있으면
					Cookie[] cookies = request.getCookies(); //깔려있는 쿠키가 있는지 확인하기위해 배열 하나만들고
					if(cookies!=null){ //깔려있으면
						for(Cookie cookie : cookies){ //루프를 돌려서
							if(cookie.getName().equals("nid_sid")){  //동일한 쿠키가 있는지 찾아서 있으면
								cookie.setPath(root); //도메인을 지정해주고(이걸 지정안해주면 어느사이트 쿠키인지 몰르잖엉)
								cookie.setMaxAge(0); //쿠키 만료기간을 0으로 해서 못쓰게 만들어서
								response.addCookie(cookie); //새로 만든 쿠키를 넘겨버린다
								break;//끝
							}
						}
					}
				}
				
				path = "/login/loginok.jsp";
			}else {
				path = "/login/loginfail.jsp";
			}			
			//session 으로 했을때는  forward나 redirect 둘다 가능
			PageMove.forward(request, response,path);
//			PageMove.redirect(request, response,path);
			
		}else if("logout".equals(act)) {
			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", null); 안좋은방법
//			session.removeAttribute("userInfo"); 일반적인방법
			session.invalidate();//세션안에 있는거 싹다 지워라
			PageMove.redirect(request, response,"/login/loginok.jsp");
		}else if("mail".equals(act)) {			
			PageMove.forward(request, response,"/mail/list.jsp");			
		}else if("logout".equals(act)) {
			PageMove.redirect(request, response,"/.jsp");
		}else if("memberlist".equals(act)) {
			
			String key = request.getParameter("key");
			String word = request.getParameter("word");			
			List<MemberDetailDto> list = memberService.memberList(key, word);
			request.setAttribute("memberlist", list);
			PageMove.forward(request, response,"/admin/memberlistxml.jsp");
		}else {
			PageMove.redirect(request, response,path);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST로 넘어가는것들 다 GET으로 넘기는 메소드가 이거닷!
		request.setCharacterEncoding(SiteConstance.CHARSET);
		doGet(request, response);
	}

}


/*
 * 
 * Session & Cookie
 * session : API HttpSession	Server  object (Memory)
 * 
 *  객체 사용 방법
 * HttpSession session = request.getSession(); 
 * session.setAttribute("name",object);
 * Object obj = session.getAttribute("name");
 * 
 *  세션 삭제 방법들 
 * session.setAttribute("name", null); 안좋은방법
 * session.removeAttribute("name"); 일반적인방법
 * session.invalidate();//세션안에 있는거 싹다 지워라
 * 
 * 
 * cookie  : API Cookie			Client  txt    (물리적파일) 보안이슈 발생가능
 * Cookie cookie = new Cookie("name", "value"); //쿠키 생성
 * cookie.setDomain("domain");  //도메인 지정
 * cookie.setPath("path");   //경로지정
 * cookie.setMaxAge(second);
 * response.addCookie(cookie); //응답페이지 헤더의 값으로 전달되서 브라우저가 받음
 * 
 * 
 * 
 * membermvc 프로젝트 참고
 * 
 * 
 * 예제
 * 					if(memberDto!=null) {//로그인 됬을때
			//////////////////////////session 설정/////////////////////////////////////////
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", memberDto);
				
			///////////////////////// Cookie 설정 /////////////////////////////////////////
				String idsave = request.getParameter("idsave");
				if("idsave".equals(idsave)) {
				Cookie cookie = new Cookie("nid_sid",id);
				cookie.setPath(root);
				cookie.setMaxAge(60*60*24*365*100);
				response.addCookie(cookie);
				}else {//아이디저장 체크박스가 해제되있으면
					Cookie[] cookies = request.getCookies(); //깔려있는 쿠키가 있는지 확인하기위해 배열 하나만들고
					if(cookies!=null){ //깔려있으면
						for(Cookie cookie : cookies){ //루프를 돌려서
							if(cookie.getName().equals("nid_sid")){  //동일한 쿠키가 있는지 찾아서 있으면
								cookie.setPath(root); //도메인을 지정해주고(이걸 지정안해주면 어느사이트 쿠키인지 몰르잖엉)
								cookie.setMaxAge(0); //쿠키 만료기간을 0으로 해서 못쓰게 만들어서
								response.addCookie(cookie); //새로 만든 쿠키를 넘겨버린다
								break;//끝
							}
						}
					}
				}
				
				path = "/login/loginok.jsp";
			}else {
				path = "/login/loginfail.jsp";
			}			
			//session 으로 했을때는  forward나 redirect 둘다 가능
			PageMove.forward(request, response,path);
//			PageMove.redirect(request, response,path);
 * 
 * 
 * 세션은 어디서 사용이 될까
 * 로그인,장바구니,찜목록등 원하는 곳에 Cookie,Session,DB를 잘이용해서 조율해야함
 * */
 