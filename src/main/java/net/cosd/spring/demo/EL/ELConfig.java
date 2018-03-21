package net.cosd.spring.demo.EL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
// 扫描到ELVo类
@ComponentScan(basePackages = "net.cosd.spring.demo.EL")
@PropertySource(value = "test.properties", encoding = "UTF-8")
public class ELConfig {

    // 获取系统name  Window 7
    @Value("#{systemProperties['os.name']}")
    private String osName;

    // 获取ELVo  name
    @Value("#{ELVo.name}")
    private String configName;

    // 获取test.properties
    @Value("${name}")
    private String propertiesName;
    @Value("${password}")
    private String propertiesPasWord;


    @Value("test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    public void out() throws IOException {
        System.out.println("osName: " + osName);
        System.out.println("ELConfig: " + configName);
        System.out.println("propertiesName: " + propertiesName);
        System.out.println("propertiesPasWord: " + propertiesPasWord);

        System.out.println(org.apache.commons.io.IOUtils.toString(testFile.getInputStream(),"UTF-8"));
        //访问网址
        System.out.println(org.apache.commons.io.IOUtils.toString(testUrl.getInputStream(),"UTF-8"));
        //获取网址
        System.out.println("testUrl.getURL():"+testUrl.getURL());
    }
}
