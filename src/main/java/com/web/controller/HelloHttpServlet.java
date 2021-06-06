
package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloHttpServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //req 表示收到Client端的請求資訊 
        String name=req.getParameter("name");
        
        //res 表示要回應給Client端的內容
        System.out.printf("Hello %s,%s\n",name,new Date());
        PrintWriter out=resp.getWriter();//透過out可以將訊息回傳給Client
        out.print("Hello: ");//把訊息寫在HTTP Response文件的Part4
        out.print(name);
        out.print(" "+new Date());
    }
    
}
