package com.llnqdx.mvnproj.enjoy.spring02.cap4.config;

import com.llnqdx.mvnproj.enjoy.spring02.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cap4MainConfig {
    //��������ע��һ��bean, ����Ϊ����ֵ������, Ĭ���ǵ�ʵ��
    /*
     * ������: ��Ҫ��Ե�ʵ��bean:Ĭ��������������ʱ�򴴽�����
     * ������:��������ʱ�򲻴�������, ������һ��ʹ��(��ȡ)bean��ʱ��Ŵ�������ʼ��

     */
    //@Lazy
    @Bean
    public Person person() {
        System.out.println("�����������person.......");
        return new Person("james", 20);
    }
}
