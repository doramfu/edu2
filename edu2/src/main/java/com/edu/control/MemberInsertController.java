package com.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		// 사용자 입력값을 읽고 디비에 반영.결과를 결과페이지.
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setMail(mail);
		
		MemberDAO dao = new MemberDAO();
		dao.insertMember(vo);
		
		req.setAttribute("member", vo); // 요청정보에 vo속성에
		
		req.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(req, resp);
	}

	

}
