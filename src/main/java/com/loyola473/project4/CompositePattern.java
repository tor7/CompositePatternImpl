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

        // ************* COMPLEX COMPONENTS/STRUCTURES *****************

        HouseComponent house = new ComplexStructure();
        HouseComponent midPortion = new ComplexStructure();
        HouseComponent lowerPortion = new ComplexStructure();

        // ************* LEAVES ****************************************

        // Roof
        HouseComponent roof = new Roof();

        // Blocks
        HouseComponent fullBlock = new FullBlock();
        HouseComponent fullBlockTerminal = new FullBlock();
        fullBlockTerminal.setTerminal(true);

        HouseComponent partialBlock = new PartialBlock();
        HouseComponent partialBlockTerminal = new PartialBlock();
        partialBlockTerminal.setTerminal(true);

        // Door
        HouseComponent doorUpper = new Blank();
        HouseComponent doorHandle = new DoorHandle();
        HouseComponent doorBottom = new Platform();

        // ************* START CONSTRUCTING HOUSE **********************

        // Construct mid portion of house
        midPortion.addComponent(fullBlock);
        midPortion.addComponent(partialBlock);
        midPortion.addComponent(partialBlockTerminal);

        midPortion.addComponent(fullBlock);
        midPortion.addComponent(partialBlock);
        midPortion.addComponent(partialBlockTerminal);

        midPortion.addComponent(fullBlock);
        midPortion.addComponent(partialBlock);
        midPortion.addComponent(partialBlockTerminal);


        // Construct lower portion of the house (includes door)
        lowerPortion.addComponent(fullBlock);
        lowerPortion.addComponent(doorUpper);
        lowerPortion.addComponent(fullBlockTerminal);

        lowerPortion.addComponent(fullBlock);
        lowerPortion.addComponent(doorHandle);
        lowerPortion.addComponent(fullBlockTerminal);

        lowerPortion.addComponent(fullBlock);
        lowerPortion.addComponent(doorBottom);
        lowerPortion.addComponent(fullBlockTerminal);

        house.addComponent(roof);
        house.addComponent(midPortion);
        house.addComponent(lowerPortion);

        house.build();


    }

    public static void main(String[] args) throws Exception{

        //For Heroku:
        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));

        //Local:
        Server server = new Server(8000);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new CompositePattern()), "/*");
        //context.addServlet(new ServletHolder(new test()), "/*");
        server.start();
        server.join();
    }
}