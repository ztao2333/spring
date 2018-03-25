package net.cosd.spring.demo.profile;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
在Spring3.1中, 只能在类级别上使用@Profile注解
从Spring3.2开始,可以在方法级别上使用@Profile注解, 与@Bean注解一同使用
 */
@Configuration
@ComponentScan(basePackages = "net.cosd.spring.demo.profile")
public class RootConfig {
}
