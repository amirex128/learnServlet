package com.example.p1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet_session", urlPatterns = "login")
public class ServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username").equals("amirex128") && req.getParameter("password").equals("a6766581")) {
            HttpSession session = req.getSession(true); // اگر مقدار true ارسال شود درصورت ساخته نشدن session id برای کاربر اول براش میسازه بعد به ما دسترسی میده معمولا در درخواست های اول کار session id هنوز ساخته نشده
            session.setAttribute("username", "amirex128@gmail.com");
            session.setAttribute("login-time", System.currentTimeMillis());
            PrintWriter writer = resp.getWriter();
            writer.println("you are log in");
        } else {
            resp.sendRedirect("/login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.invalidate();

    }
}
