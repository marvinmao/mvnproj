package com.llnqdx.mvnproj.mapper;

import com.llnqdx.mvnproj.model.FdfsFileTbl;
import com.llnqdx.mvnproj.model.FdfsFileTblCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FdfsFileTblMapper {
    long countByExample(FdfsFileTblCriteria example);

    int deleteByExample(FdfsFileTblCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(FdfsFileTbl record);

    int insertSelective(FdfsFileTbl record);

    List<FdfsFileTbl> selectByExample(FdfsFileTblCriteria example);

    FdfsFileTbl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FdfsFileTbl record, @Param("example") FdfsFileTblCriteria example);

    int updateByExample(@Param("record") FdfsFileTbl record, @Param("example") FdfsFileTblCriteria example);

    int updateByPrimaryKeySelective(FdfsFileTbl record);

    int updateByPrimaryKey(FdfsFileTbl record);
}