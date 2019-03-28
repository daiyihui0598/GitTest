package com.springboot.mybatises.Config.securityConfig;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：springcloud security
 * 类名称：
 * 类描述：出现权限限制返回HTTP_CODE为403的时候自定义展示页面以及内容。
 * 创建人：daiyihui-戴艺辉
 * 邮箱：daiyihui@yidianlife.com
 * 创建时间：2019/3/27 9:58
 * 修改备注：
 * @version1.0
 * 
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
     public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException accessDeniedException) throws IOException {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        if(auth!=null){
            System.out.println("用户名：======"+auth.getName()+",权限"+auth.getCredentials());
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/401");

    }

















}
