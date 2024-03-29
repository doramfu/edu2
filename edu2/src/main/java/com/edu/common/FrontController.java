package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.control.CommentAddController;
import com.edu.control.CommentGetController;
import com.edu.control.CommentListController;
import com.edu.control.CommentUpdateController;
import com.edu.control.LoginController;
import com.edu.control.MemberDeleteController;
import com.edu.control.MemberInsertController;
import com.edu.control.MemberListController;
import com.edu.control.MemberSearchController;
import com.edu.control.MemberUpdateController;

public class FrontController extends HttpServlet {
	
	Map<String,Controller> map = null;
	
	@Override
	public void init() throws ServletException {
		map = new HashMap<String,Controller>();
		
		// url패턴 - 컨트롤러 등록
		map.put("/memberList.do", new MemberListController());
		map.put("/memberInsert.do", new MemberInsertController());
		map.put("/memberSearch.do", new MemberSearchController());
		map.put("/memberDelete.do", new MemberDeleteController());
		map.put("/memberUpdate.do", new MemberUpdateController());
		
		
		// 댓글관련.
		map.put("/commentAdd.do", new CommentAddController());
		map.put("/commentList.do", new CommentListController());
		map.put("/commentGet.do", new CommentGetController());
		map.put("/commentUpdate.do", new CommentUpdateController());

		// 로그인관련
		map.put("/login.do", new LoginController());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리.
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI(); // /edu2/memberList.do
		String context = req.getContextPath(); //  /edu2
		String path = uri.substring(context.length());
		
		Controller control = map.get(path);
		control.execute(req, resp);
	}
	
}
