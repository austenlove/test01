package org.zerock.test01.controller;

import org.zerock.test01.dto.MemberDTO;
import org.zerock.test01.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listServlet", urlPatterns = "/list")
public class ListController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("List Controller");

        try {
            List<MemberDTO> memberDTOList = memberService.list();
            req.setAttribute("memberDTOList", memberDTOList);
            req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException("list error");
        }

    }

}
