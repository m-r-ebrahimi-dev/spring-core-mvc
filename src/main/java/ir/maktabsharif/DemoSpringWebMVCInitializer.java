package ir.maktabsharif;

import ir.maktabsharif.config.DemoWebMVCAppConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DemoSpringWebMVCInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(DemoWebMVCAppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        ServletRegistration.Dynamic addServlet = servletContext.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
        addServlet.setLoadOnStartup(1);
        addServlet.addMapping("/");

    }
}
