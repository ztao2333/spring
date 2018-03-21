package net.cosd.spring.demo;


import net.cosd.spring.demo.EL.ELConfig;
import net.cosd.spring.demo.EL.ELVo;
import net.cosd.spring.demo.EL.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ELTest {

    @Autowired
    private ELVo elVo;

    @Autowired
    private ELConfig elConfig;

    @Test
    public void testEL() throws IOException {
        System.out.println(elVo.getName());
        elConfig.out();
    }

}
