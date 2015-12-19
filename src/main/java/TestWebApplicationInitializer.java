import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TestWebApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext container) {
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
    dispatcherServlet.register(SpringMvcConfig.class);

		ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		registration.setLoadOnStartup(1);
		registration.addMapping("/test/*");
	}
}
