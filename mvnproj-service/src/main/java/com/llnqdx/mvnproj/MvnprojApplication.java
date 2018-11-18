package com.llnqdx.mvnproj;

import com.llnqdx.mvnproj.utils.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maofujiang
 * @Description:
 * @since 2018/11/10
 */
@SpringBootApplication(scanBasePackages = "com.llnqdx.mvnproj")
@MapperScan("com.llnqdx.mvnproj.mapper")
@RestController
public class MvnprojApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvnprojApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return StringUtils.print("hello spring boot");
    }
}
