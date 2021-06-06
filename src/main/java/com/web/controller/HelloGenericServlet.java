package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*  
    client端請求URL 的請求資訊 http://localhost:8080/JavaWeb20210531/hi?name=John
    /JavaWeb20210531-> Context path 要到META-INF/context.xml中設定與配置
    /hi             -> url-pattern,要到 web.xml中設定與配置
*/
public class HelloGenericServlet extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //req 表示收到Client端的請求資訊 
        String name=req.getParameter("name");
        
        //res 表示要回應給Client端的內容
        System.out.printf("Hi %s,%s\n",name,new Date());
        PrintWriter out=res.getWriter();//透過out可以將訊息回傳給Client
        out.print("Hi: ");//把訊息寫在HTTP Response文件的Part4
        out.print(name);
        out.print(" "+new Date());
    }
    
}
