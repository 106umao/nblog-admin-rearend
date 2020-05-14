package club.bangju.pojo.DTO;

import club.bangju.util.ResponseStatusCode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonSerialize
public class ResponseDTO<T> {
    private String msg;
    private Integer code;
    private T data;

    public static <R> ResponseDTO<R> ok(R data) {
        ResponseDTO<R> r = new ResponseDTO<>();
        r.setCode(ResponseStatusCode.SUCCESS);
        r.setMsg("success");
        r.setData(data);
        return r;
    }
    public static  ResponseDTO ok() {
        ResponseDTO r = new ResponseDTO();
        r.setCode(ResponseStatusCode.SUCCESS);
        r.setMsg("success");
        return r;
    }

    public static <R> ResponseDTO<R> failed() {
        ResponseDTO<R> r = new ResponseDTO<>();
        r.setCode(ResponseStatusCode.FAILED);
        r.setMsg("failed");
        return r;
    }
}
