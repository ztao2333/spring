package net.cosd.spring.demo;

import net.cosd.spring.demo.profile.Profile;
import net.cosd.spring.demo.profile.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
// 激活profile
@ActiveProfiles("prod")
public class ProfileTest {

    @Autowired
    private Profile profile;

    @Test
    public void profileTest() {
        System.out.println(profile.envInfo());
    }

}
