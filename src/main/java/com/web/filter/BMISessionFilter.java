package com.web.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/controller/bmi_session")
public class BMISessionFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equalsIgnoreCase("get")) {
            chain.doFilter(req, res);
        } else {
            //驗證授權碼
            String code = req.getParameter("code");
            HttpSession session = req.getSession();
            Object authCode = session.getAttribute("authCode");
            //PrintWriter out = res.getWriter();
            //out.print(code + "==" + authCode);
            if (authCode != null && code.equals(authCode)) {
                session.setAttribute("authCode", null);
                chain.doFilter(req, res);
            } else {
                session.invalidate();
                res.getWriter().print(code + "==" + authCode);
            }

        }

    }

}
