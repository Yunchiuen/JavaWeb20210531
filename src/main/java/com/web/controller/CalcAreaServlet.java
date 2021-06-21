package com.web.controller;

import com.web.service.CalcAreaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/CalcArea")//url-pattern
public class CalcAreaServlet extends HttpServlet {
//    沒有doGet會405錯誤
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("sorry~~");
//    }

    private CalcAreaService service = new CalcAreaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收單筆參數(單一名稱無重複 type=1&r=10)
//        String string_type = req.getParameter("type");
//        String string_r = req.getParameter("r");
//        int type=Integer.parseInt(string_type);
//        int r=Integer.parseInt(string_r);
        //1.接收多筆參數(多重複名稱 type=1&r=10&type=2&r=20&type=2&r=30)
        String[] types = req.getParameterValues("type");
        String[] rs = req.getParameterValues("r");

        //2.邏輯運算
//        double area=service.getAreaResult(type, r);
//        String typeName = service.getNameByType(type);
        List<Map> list = service.getAreaResult(types, rs);
        //3.建立分派器
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/calcAreaResult.jsp");
        //3.1新增/設定 request 屬性,傳遞給jsp頁面使用
//        req.setAttribute("r", String.format("%d", r));
//        req.setAttribute("result", String.format("%.2f", area));
//        req.setAttribute("typeName", typeName);
        req.setAttribute("list", list);
        //3.2傳送
        rd.forward(req, resp);
        //resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }

}
