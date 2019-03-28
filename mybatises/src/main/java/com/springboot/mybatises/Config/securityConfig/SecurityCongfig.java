package com.springboot.mybatises.Config.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * 项目名称：
 * 类名称：springcloud security安全配置
 * 类描述：
 * 创建人：daiyihui-戴艺辉
 * 邮箱：daiyihui@yidianlife.com
 * 创建时间：2019/3/27 9:56
 * 修改备注：
 * @version1.0
 *
 */
@EnableWebSecurity
public class SecurityCongfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**").permitAll() // 允许访问资源
                .antMatchers("/", "/home", "/about").permitAll() //允许访问这三个路由
                .antMatchers("/admin/**").hasAnyRole("ADMIN") // 满足该条件下的路由需要ROLE_ADMIN的角色
                .antMatchers("/users/**").hasAnyRole("USER") // 满足该条件下的路由需要ROLE_USER的角色
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login-error")
                .and().logout().logoutUrl("/")
                .and().exceptionHandling().accessDeniedPage("/401");
    }



      //create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication() .withUser("user").password("user").roles("USER")
                .and() .withUser("admin").password("admin").roles("ADMIN");
    }











}
