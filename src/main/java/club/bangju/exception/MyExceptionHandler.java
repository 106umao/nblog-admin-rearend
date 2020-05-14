package club.bangju.exception;

import club.bangju.pojo.DTO.ResponseDTO;
import com.mysql.cj.MysqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
    Logger logger = LoggerFactory.getLogger(MysqlConnection.class);



    @ResponseBody
    @ExceptionHandler(Exception.class)

    public Object allExceptionHandler(Exception e) {
        logger.error("异常处理:",e.getMessage());
        e.printStackTrace();
        ResponseDTO<Object> failed = ResponseDTO.failed();
        failed.setCode(500);
        return failed;
    }
}
