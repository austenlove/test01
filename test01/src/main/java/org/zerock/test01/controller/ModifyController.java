package org.zerock.test01.controller;

import org.zerock.test01.MemberService;
import org.zerock.test01.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyController", urlPatterns = "/modify")
public class ModifyController extends HttpServlet {

    private MemberService memberService = MemberService.INSTANCE;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            MemberDTO memberDTO = memberService.getOne(tno);
            req.setAttribute("memberDTO", memberDTO);

            req.getRequestDispatcher("/WEB-INF/modify.jsp").forward(req, resp);

        } catch(Exception e) {

            System.out.println(e.getMessage());
            throw new ServletException("read error");
        }
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        MemberDTO memberDTO = MemberDTO.builder()
                .tno(Long.parseLong(req.getParameter("tno")))
                .name(req.getParameter("name"))
                .id(req.getParameter("id"))
                .pw(req.getParameter("pw"))
                .age(Integer.parseInt(req.getParameter("age")))
                .gender(req.getParameter("gender"))
                .hobby(getHobbyString(req.getParameterValues("hobby")))
                .travel(req.getParameter("travel"))
                .content(req.getParameter("content"))
                .build();

        System.out.println("memberDTO: " + memberDTO);

        try {
            memberService.modify(memberDTO);

        } catch (Exception e) {
            e.printStackTrace();

        }

        resp.sendRedirect("/list");
    }

    public String getHobbyString(String[] hobbies) {
        if(hobbies == null || hobbies.length == 0) {
            return "";
        }
        return String.join(", ", hobbies);
    }


}
