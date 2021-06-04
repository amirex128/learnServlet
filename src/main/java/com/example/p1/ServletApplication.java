package com.example.p1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// سشن ها تنها برای یک کاربر هستش و در سرور ذخیره میشود و ایدی ان در کوکی و خود کوکی کلا در مرورگر ذخیره میشود برای هر کاربر ولی اپلیکیشن ها برای همه ریکوست ها یک سان هست میتوان از ان برای شمارش بازدید ها مثلا استفاده کرد
//The application object in JSP is called the ServletContext object in a servlet.
@WebServlet(name = "servlet_application", urlPatterns = "counter")
public class ServletApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // در jsp با نام application شناخته میشود ولی در servlet با نام servletContext شناخته میشود
        ServletContext application = req.getServletContext();
        Integer counter = (Integer) application.getAttribute("counter");
        if (counter == null) {
            counter = 1;
        }
        application.setAttribute("counter", counter++);
        PrintWriter writer = resp.getWriter();
        writer.println(application.getAttribute("counter"));
    }
}
