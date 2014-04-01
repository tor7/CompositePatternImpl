package com.loyola473.project4;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompositePattern extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Java Application to deploy into heroku!\n");



//        Map<String, String> envMap = System.getenv();
//        resp.getWriter().print(envMap);
    }

    public static void main(String[] args) throws Exception{


        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        //Server server = new Server(8000);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new CompositePattern()),"/*");
        server.start();
        server.join();
    }
}