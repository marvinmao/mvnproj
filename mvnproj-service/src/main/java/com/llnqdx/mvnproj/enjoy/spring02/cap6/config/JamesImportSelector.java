package com.llnqdx.mvnproj.enjoy.spring02.cap6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class JamesImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //����ȫ������bean
        return new String[]{"com.llnqdx.mvnproj.enjoy.spring02.cap6.bean.Fish", "com.llnqdx.mvnproj.enjoy.spring02.cap6.bean.Tiger"};
    }
}
