package org.zerock.test01.controller;

import org.zerock.test01.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet(name = "removeController", urlPatterns = "/remove")
public class RemoveController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("Member Remove Controller");

        Long tno = Long.parseLong(req.getParameter("tno"));

        System.out.println("tno: " + tno);

        try {
            memberService.remove(tno);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServletException("remove error");
        }

        resp.sendRedirect("/list");
    }

}
