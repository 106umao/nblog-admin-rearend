package club.bangju.exception;

import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.util.ResponseStatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author OrangeCat
 */
public class SimpleAccessDeniedHandler implements AccessDeniedHandler {
    Logger logger = LoggerFactory.getLogger(SimpleAccessDeniedHandler.class);
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        try (PrintWriter printWriter = response.getWriter()) {
            logger.info("认证失败");
            ResponseDTO failed = ResponseDTO.failed();
            response.setCharacterEncoding("utf-8");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            failed.setMsg("认证失败");
            failed.setCode(ResponseStatusCode.NOT_AUTHORIZATION);
            printWriter.write(new ObjectMapper().writeValueAsString(failed));
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
