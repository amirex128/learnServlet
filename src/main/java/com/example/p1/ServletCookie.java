package com.example.p1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

@WebServlet(name = "servlet_cookie", urlPatterns = "servlet/cookie")
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie user_id = new Cookie("user_id", "128");
        user_id.setMaxAge(60*60*24*365);
        user_id.setPath("/");
//        user_id.setDomain("localhost:8080");
        user_id.setHttpOnly(false); // آیا جاوااسکریپت به کوکی دسترسی داشته باشه یا نه
        user_id.setSecure(false);// فقط بر روی https دستسرسی داشته باشد یا نه
        resp.addCookie(user_id);


        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        writer.println("your cookie is :");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            writer.println(cookie.getName());
            writer.println(cookie.getValue());
        }

    }
}
