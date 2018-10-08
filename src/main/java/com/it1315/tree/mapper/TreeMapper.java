package com.it1315.tree.mapper;

import com.it1315.tree.entity.Tree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by dly on 2018/10/8
 */
@Mapper
public interface TreeMapper {
    List<Tree> findById(Integer id);
}
