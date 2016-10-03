package utils;

import com.google.inject.Binder;
import com.google.inject.Guice;

import com.tapatron.reg.JacksonHALConfig;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;
import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

public abstract class JettyGuiceRestEasyTest {

  protected abstract void configure(Binder b);

  private Server server;

  @Before
  public void setUp() throws Exception {

    // Swap default object mapper with one that understands links
    ResteasyProviderFactory.getInstance().registerProviderInstance(JacksonHALConfig.class);

    server = new Server(9000);
    ServletContextHandler servletHandler = new ServletContextHandler();
    servletHandler.addEventListener(Guice.createInjector(new TestModule()).getInstance((GuiceResteasyBootstrapServletContextListener.class)));
    servletHandler.addServlet(HttpServletDispatcher.class, "/*");

    server.setHandler(servletHandler);
    server.start();
  }

  @After
  public void tearDown() throws Exception {
    server.stop();
  }

  protected void configureRequestContext() {
    return;
  }

  private class TestModule extends RequestScopeModule {

    @Override
    protected void configure() {
      super.configure();
      bind(ContainerRequestFilterImpl.class).toInstance(new ContainerRequestFilterImpl());
      JettyGuiceRestEasyTest.this.configure(this.binder());
    }
  }

  @Provider
  private class ContainerRequestFilterImpl implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
      configureRequestContext();
    }
  }
}
