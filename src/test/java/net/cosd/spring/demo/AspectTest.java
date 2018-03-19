package net.cosd.spring.demo;

import net.cosd.spring.demo.aop.AspectService;
import net.cosd.spring.demo.aop.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*
使用spring中对Junit框架的整合功能
除了junit4和spring的jar包，还需要spring-test.jar。引入如下依赖：

@RunWith 注释标签是 Junit 提供的，用来说明此测试类的运行者，
    这里用了 SpringJUnit4ClassRunner，这个类是一个针对 Junit 运行环境的自定义扩展，
    用来标准化在 Spring 环境中 Junit4.5 的测试用例，例如支持的注释标签的标准化
@ContextConfiguration 注释标签是 Spring test context 提供的，
    用来指定 Spring 配置信息的来源，支持指定 XML 文件位置或者 Spring 配置类名，
    RootConfig.java
    这里我们指定 classpath 下的 /config/Spring-db1.xml 为配置文件的位置
@Transactional 注释标签是表明此测试类的事务启用，这样所有的测试方案都会自动的 rollback，
    即您不用自己清除自己所做的任何对数据库的变更了
@Autowired 体现了我们的测试类也是在 Spring 的容器中管理的，他可以获取容器的 bean 的注入
    ，您不用自己手工获取要测试的 bean 实例了
testGetAccountById 是我们的测试用例：注意和上面的 AccountServiceOldTest
    中相同的测试方法的对比，这里我们不用再 try-catch-finally 了，事务管理自动运行，
    当我们执行完成后，所有相关变更会被自动清除
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AspectTest {

    @Autowired
    private AspectService aspectService;

    @Test
    public void testAop() {
        aspectService.sayHello("ztao2333@email.com");
    }
}



