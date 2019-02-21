package com.llnqdx.mvnproj.enjoy.spring02.cap3.config;

import com.llnqdx.mvnproj.enjoy.spring02.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cap3MainConfig {
    //��������ע��һ��bean, ����Ϊ����ֵ������, Ĭ���ǵ�ʵ��
    /*
     * prototype:��ʵ��: IOC����������ʱ��,IOC��������������ȥ���÷�����������, ����ÿ�λ�ȡ��ʱ��Ż���÷�����������
     * singleton:��ʵ��(Ĭ��):IOC����������ʱ�����÷����������󲢷ŵ�IOC������,�Ժ�ÿ�λ�ȡ�ľ���ֱ�Ӵ���������(��Map.get)��ͬһ��bean
     * request: ��Ҫ���webӦ��, �ݽ�һ�����󴴽�һ��ʵ��
     * session:ͬһ��session����һ��ʵ��
     */
    //@Scope("prototype")
    @Bean
    public Person person() {
        return new Person("james", 20);
    }
}
