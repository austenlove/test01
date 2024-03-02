package org.zerock.test01.controller;

import org.zerock.test01.MemberService;
import org.zerock.test01.dto.MemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="testController", urlPatterns = "/register")
public class RegisterController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Register Controller");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/register.jsp");

        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDTO memberDTO = MemberDTO.builder()
                .name(req.getParameter("name"))
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                .age(Integer.parseInt(req.getParameter("age")))
                .gender(req.getParameter("gender"))
                .hobby(getHobbyString(req.getParameterValues("hobby")))
                .travel(req.getParameter("travel"))
                .content(req.getParameter("content"))
                .build();


        System.out.println(memberDTO);

        try {
            memberService.register(memberDTO);

        } catch(Exception e) {
            e.printStackTrace();

        }

        resp.sendRedirect("/list");
    }

    private String getHobbyString(String[] hobbies) {

        if(hobbies == null || hobbies.length == 0) {
            return "";
        }

        return String.join(", ", hobbies);
    }

}
