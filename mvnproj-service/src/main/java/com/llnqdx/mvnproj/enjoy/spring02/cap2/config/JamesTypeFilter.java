package com.llnqdx.mvnproj.enjoy.spring02.cap2.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class JamesTypeFilter implements TypeFilter {
    private ClassMetadata classMetadata;

    /*
     * MetadataReader:��ȡ����ǰ����ɨ�������Ϣ
     * MetadataReaderFactory:���Ի�ȡ�������κ�����Ϣ
     */

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
            throws IOException {
        //��ȡ��ǰ��ע�����Ϣ
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //��ȡ��ǰ����ɨ�������Ϣ
        classMetadata = metadataReader.getClassMetadata();
        //��ȡ��ǰ����Դ(���·��)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("----->" + className);
        if (className.contains("order")) {//�������er�ַ�, ��ƥ��ɹ�,����true
            return true;
        }
        return false;
    }

}
