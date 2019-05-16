package com.llnqdx.mvnproj.enjoy.spring02.cap6.config;

import com.llnqdx.mvnproj.enjoy.spring02.cap6.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class JamesImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /*
     *AnnotationMetadata:��ǰ���ע����Ϣ
     *BeanDefinitionRegistry:BeanDefinitionע����
     *    ��������Ҫ���ӵ������е�bean����;
     *    @Scope
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean bean1 = registry.containsBeanDefinition("com.llnqdx.mvnproj.enjoy.spring02.cap6.bean.Dog");
        boolean bean2 = registry.containsBeanDefinition("com.llnqdx.mvnproj.enjoy.spring02.cap6.bean.Cat");
        //���Dog��Catͬʱ����������IOC������,��ô����Pig��, ���뵽����
        //��������Ҫע���bean, ��bean���з�װ,
        if (bean1 && bean2) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", beanDefinition);
        }
    }

}