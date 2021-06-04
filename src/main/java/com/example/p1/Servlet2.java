package com.example.p1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// ساخت یک سرولت از طریق یک انوتیشن
@WebServlet(name = "amirex servlet",urlPatterns = {"/annotation/servlet/class","/amirex"})
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>annotation servlet page with Annotation</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }
}
