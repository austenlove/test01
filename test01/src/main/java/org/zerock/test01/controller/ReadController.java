package org.zerock.test01.controller;

import org.zerock.test01.MemberService;
import org.zerock.test01.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "readController", urlPatterns = "/read")
public class ReadController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("Member Read Controller");

        try {
            // req에서 tno 추출
            Long tno = Long.parseLong(req.getParameter("tno"));

            // 해당 tno의 DTO 추출
            MemberDTO memberDTO = memberService.getOne(tno);

            req.setAttribute("memberDTO", memberDTO);
            req.getRequestDispatcher("/WEB-INF/read.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("read error");
        }


    }
}
