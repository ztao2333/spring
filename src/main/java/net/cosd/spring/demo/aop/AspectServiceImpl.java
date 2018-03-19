package net.cosd.spring.demo.aop;

import org.springframework.stereotype.Service;

@Service("AspectService")
public class AspectServiceImpl implements AspectService {

    @Override
    public void sayHello(String email) {
        System.out.println("sayHello to >>>>{}" + email);
        System.out.println("++++++++++++++++++++++");
    }
}

