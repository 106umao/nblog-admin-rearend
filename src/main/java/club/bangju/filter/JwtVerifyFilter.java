package club.bangju.filter;

import club.bangju.pojo.DO.UserDO;
import club.bangju.pojo.DTO.PayloadDTO;
import club.bangju.pojo.DTO.ResponseDTO;
import club.bangju.util.JwtUtils;
import club.bangju.util.ResponseStatusCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;

public class JwtVerifyFilter extends BasicAuthenticationFilter {
    public Logger logger = LoggerFactory.getLogger(JwtVerifyFilter.class);
    private final PublicKey publicKey;

    public JwtVerifyFilter(AuthenticationManager authenticationManager,PublicKey publicKey ) {
        super(authenticationManager);
        this.publicKey = publicKey;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        if (token == null ) {
            //如果携带错误的token，则给用户提示请登录！
            try (PrintWriter out = response.getWriter()) {
                chain.doFilter(request, response);
                response.setCharacterEncoding("utf-8");
                response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                ResponseDTO failed = ResponseDTO.builder().code(ResponseStatusCode.FORBIDDEN).msg("请登录").build();
                out.write(new ObjectMapper().writeValueAsString(failed));
                out.flush();
            } catch (Exception e) {
                logger.info("认证失败");
                e.printStackTrace();
            }
        } else {
            PayloadDTO<UserDO> payload = JwtUtils.getInfoFromToken(token, publicKey, UserDO.class);
            UserDO user = payload.getUserInfo();
            if(user!=null){
                // 生成security 规范的token 存入context中由controller之类的methoed授权使用
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            }
        }
    }




}
