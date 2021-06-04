package com.example.p1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletForGetConfigFromWebXML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username_db = getInitParameter("username_db");
        String password_db = getInitParameter("password_db");

        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        writer.println(username_db);
        writer.println(password_db);
    }
}
