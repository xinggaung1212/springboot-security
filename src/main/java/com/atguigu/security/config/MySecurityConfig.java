package com.atguigu.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers("/level1/**").hasRole("VIP1").
                antMatchers("/level2/**").hasRole("VIP2").
                antMatchers("/level3/**").hasRole("VIP3");
        //super.configure(http);  /login post 验证登录
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin")
                .loginProcessingUrl("/login");
        //1、/login来到登录页.
        //2、/login?error错误页面
        http.logout().logoutSuccessUrl("/");//注销成功！
        http.rememberMe();//开启记住我，功能
    }
    //认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3")
                .and()
                .withUser("wagnwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3");
    }
}
