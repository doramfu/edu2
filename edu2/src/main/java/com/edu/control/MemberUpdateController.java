package com.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.dao.MemberDAO;
import com.edu.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자입력 정보 읽어와서 디비반영 결과: memberResult/memberUpdateOutput.jsp
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String passwd1 = req.getParameter("passwd");
		String mail = req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd1);
		vo.setMail(mail);
		
		MemberDAO dao = new MemberDAO();
		dao.updateMember(vo);
		
		//처리결과.
		req.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(req, resp);
		
	}

}
