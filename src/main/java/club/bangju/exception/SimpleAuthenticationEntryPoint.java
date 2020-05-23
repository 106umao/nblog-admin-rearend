package club.bangju.exception;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.util.ResponseStatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author OrangeCat
 */
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {
    Logger logger = LoggerFactory.getLogger(SimpleAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter printWriter;
        printWriter = response.getWriter();
        try  {
            logger.info("认证失败");
            ResponseDTO failed = ResponseDTO.failed();
            failed.setMsg("认证失败");
            failed.setCode(ResponseStatusCode.NOT_AUTHORIZATION);
            printWriter.write(new ObjectMapper().writeValueAsString(failed));
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }
    }
}
