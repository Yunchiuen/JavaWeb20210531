package com.web.controller;

import com.web.service.RegisterService;
import java.io.IOException;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/Register")
public class RegisterServlet extends HttpServlet {

    private RegisterService service = new RegisterService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //sno=01&eno=1z0-808&time=1&time=2&pay=true&memo=zzz
        String sno = req.getParameter("sno");
        String eno = req.getParameter("eno");
        List<Integer> time = Stream.of(req.getParameterValues("time"))
                .map(t -> Integer.parseInt(t))
                .collect(toList());
        Boolean pay = Boolean.parseBoolean(req.getParameter("pay"));
        String meno = req.getParameter("meno");

        //分派器
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/registerResult.jsp");
        //配置參數
        req.setAttribute("sno", sno);
        req.setAttribute("eno", eno);
        req.setAttribute("time", service.getTimeNamesById(time));
        req.setAttribute("pay", pay);
        req.setAttribute("meno", meno);

        //分派
        rd.forward(req, resp);
    }

}
