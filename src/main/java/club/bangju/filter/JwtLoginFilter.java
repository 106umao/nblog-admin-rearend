package club.bangju.filter;

import club.bangju.pojo.DO.RoleDO;
import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.util.JwtUtils;
import club.bangju.util.ResponseStatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
/**
  *@author orangecat
  *@desc TODO
  *@date 2020/5/12 18:08
  **/
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private PrivateKey privateKey;

    /**
     * @desc TODO 构造器,构造的同时注入需使用的参数
     * @params [authenticationManager, privateKey]
     * @return
     * @date 2020/5/12 18:08
     **/
    public JwtLoginFilter(AuthenticationManager authenticationManager ,PrivateKey privateKey) {
        this.authenticationManager = authenticationManager;
        this.privateKey = privateKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserDO user = new ObjectMapper().readValue(request.getInputStream(), UserDO.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            return authenticationManager.authenticate(authRequest);
        }catch (Exception e){
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                ResponseDTO failed = ResponseDTO.failed();
                failed.setMsg("认证失败");
                failed.setCode(ResponseStatusCode.NOT_AUTHORIZATION);
                out.write(new ObjectMapper().writeValueAsString(failed));
                out.flush();
                out.close();
            }catch (Exception outEx){
                outEx.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDO user = new UserDO();
        user.setUsername(authResult.getName());
        user.setRoles((List<RoleDO>) authResult.getAuthorities());
        String token = JwtUtils.generateTokenExpireInMinutes(user, privateKey, 24 * 60);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            ResponseDTO ok = ResponseDTO.ok();
            ok.setMsg("认证通过");
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            ok.setData(map);
            out.write(new ObjectMapper().writeValueAsString(ok));
            out.flush();
            out.close();
        }catch (Exception outEx){
            outEx.printStackTrace();
        }
    }

}
