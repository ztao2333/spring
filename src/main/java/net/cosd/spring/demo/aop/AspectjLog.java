package net.cosd.spring.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


// 切面类

/*
优先顺序来织入增强处理：在进入连接点时，高优先级的增强处理将先被织入；
在退出连接点时，高优先级的增强处理会后被织入.
当不同的切面里的两个增强处理需要在同一个连接点被织入时，Spring AOP将以随机的顺序来织入这两个增强处理
直接使用@Order注解来修饰一个切面类，使用 @Order 时可指定一个int型的value属性，该属性值越小，则优先级越高。
 */
@Order(1)
@Aspect
@Component
public class AspectjLog {

    // 此处定义一个通用的切点,以便下方4个通知使用
    // execution: 在方法执行时触发  *: 返回任意类型
    // net.cosd.spring.demo.aop.AspectService: 方法名  ..意思: 任意参数
    @Pointcut("execution(* net.cosd.spring.demo.aop.AspectService.sayHello(..))")
    public void logAop() {
    }

    /*
    同一个类顺序：around之前通知》before通知》around之后通知》after通知》afterReturn通知
    自定义前置通知Before>>>{}ztao2333@email.com
    前置通知Before>>{}ztao2333@email.com
    sayHello to >>>>{}ztao2333@email.com
    ++++++++++++++++++++++
    自定义后置通知After>>>{}ztao2333@email.com
    自定义返回通知AfterReturning>>>{}ztao2333@email.com
    后置通知After>>{}ztao2333@email.com
    返回通知AfterReturning>>{}ztao2333@email.com
     */

    // 如果没有定义公用的切点或者需要单独指定其他切点,可以使用表达式指定
    // @Before("execution(* net.cosd.spring.demo.aop.AspectService(..)) && args(email)")
    @Before("logAop() && args(email)")
    public void logBefore(JoinPoint joinPoint, String email) {
        System.out.println("前置通知Before>>{}" + email);
    }

    // 通知方法会在目标方法返回或抛出异常后调用
    @After("logAop() && args(email)")
    public void logAfter(String email) {
        System.out.println("后置通知After>>{}" + email);
    }

    // 通知方法会在目标方法返回后调用
    @AfterReturning("logAop() && args(email)")
    public void logAfterReturning(String email) {
        System.out.println("返回通知AfterReturning>>{}" + email);
    }


    // 通知方法会在目标方法抛出异常后调用
    @AfterThrowing("logAop() && args(email)")
    public void logAfterThrow(String email) {
        System.out.println("异常通知AfterThrowing>>{}" + email);
    }

    // 环绕通知功能很强, 可以替代上面所有的通知
    @Around("logAop() && args(email)")
    public void logAround(ProceedingJoinPoint jp, String email) {
        try {
            System.out.println("自定义前置通知Before>>>{}" + email);
            jp.proceed();//将控制权交给被通知的方法，也就是执行sayHello方法
            System.out.println("自定义后置通知After>>>{}" + email);
        } catch (Throwable throwable) {
            System.out.println("异常处理>>>>{}" + email);
            throwable.printStackTrace();
        }
        System.out.println("自定义返回通知AfterReturning>>>{}" + email);
    }
}
