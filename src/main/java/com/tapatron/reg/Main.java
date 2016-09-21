package com.tapatron.reg;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class Main {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        GuiceResteasyServletContextListener contextListener = new GuiceResteasyServletContextListener();
        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.addEventListener(contextListener);
        servletHandler.addServlet(HttpServletDispatcher.class, "/*");

        server.setHandler(servletHandler);
        server.start();
        server.join();
    }
}
