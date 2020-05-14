package club.bangju.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//@EnableWebSecurity
//@EnableWebMvcSecurity
@ImportResource(locations = {"classpath:root-config.xml"})
@Import(SecurityConfig.class)
@Configuration
public class RootConfig {

}
