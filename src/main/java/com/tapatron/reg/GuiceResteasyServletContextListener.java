package com.tapatron.reg;

import com.google.inject.Module;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class GuiceResteasyServletContextListener extends GuiceResteasyBootstrapServletContextListener {
  @Override
  protected List<? extends Module> getModules(ServletContext context) {
    List<Module> modules = new ArrayList<>();
    modules.add(new AppModule());
    return modules;
  }
}
