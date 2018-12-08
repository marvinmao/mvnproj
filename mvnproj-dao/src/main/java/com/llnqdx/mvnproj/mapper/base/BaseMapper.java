package com.llnqdx.mvnproj.mapper.base;

import com.llnqdx.mvnproj.base.BaseEntity;
import com.llnqdx.mvnproj.base.BaseExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author marvinmao
 * @Description:
 * @since 2018/11/10
 */
public interface BaseMapper<E extends BaseEntity, C extends BaseExample> {
    long countByExample(C example);

    int deleteByExample(C example);

    int deleteByPrimaryKey(String uuid);

    int insert(E record);

    int insertSelective(E record);

    List<E> selectByExample(C example);

    List<E> selectByExampleWithRowBounds(C example, RowBounds rowBounds);

    E selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") E record, @Param("example") C example);

    int updateByExample(@Param("record") E record, @Param("example") C example);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
