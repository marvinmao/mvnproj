package com.llnqdx.mvnproj.enjoy.spring02.cap1.config;

import com.llnqdx.mvnproj.enjoy.spring02.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//������====�����ļ�
@Configuration
public class MainConfig {
    //��������ע��һ��bean, ����Ϊ����ֵ������,
    @Bean("abcPerson")
    public Person person01() {
        return new Person("james", 20);
    }
}
