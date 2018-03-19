package net.cosd.spring.demo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "net.cosd.spring.demo")
// 开启AspectJ自动扫描,因为spring默认是关闭的
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RootConfig {
}
