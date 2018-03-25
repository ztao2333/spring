package net.cosd.spring.demo.profile;

import org.springframework.stereotype.Service;

@Service("profile")
@org.springframework.context.annotation.Profile("prod")
public class ProdProfileImpl implements Profile{
    @Override
    public String envInfo() {
        return "prodEnv";
    }
}
