package com.it1315.tree.service;

import com.it1315.tree.entity.Tree;

import java.util.List;

/**
 * Created by dly on 2018/10/8
 */
public interface TreeService {

    List<Tree> findTreeById(Integer id);

}
