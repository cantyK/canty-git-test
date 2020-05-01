import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
//web配置，取代web.xml
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //创建web服务器（web上下文）
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);//web配置在MyMvcconfig里配置了。
        context.setServletContext(servletContext);//设定容器中的servletcontext
        Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        //注册DispatcherServlet类的servlet，可以直接对应后面的控制器
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
