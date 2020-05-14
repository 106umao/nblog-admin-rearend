package club.bangju.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

//    @Override
//    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        FilterRegistration.Dynamic dynamic = servletContext.addFilter("springSecurityFilterChain", proxy);
//        dynamic.addMappingForUrlPatterns(null, true, "/*");
//        return dynamic;
//    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
