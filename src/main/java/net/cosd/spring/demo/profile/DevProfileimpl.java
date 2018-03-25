package net.cosd.spring.demo.profile;

import org.springframework.stereotype.Service;

@Service("profile")
@org.springframework.context.annotation.Profile("dev")
public class DevProfileimpl implements Profile {
    @Override
    public String envInfo() {
        return "devEnv";
    }
}
