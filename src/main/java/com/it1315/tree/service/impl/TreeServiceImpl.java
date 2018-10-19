package com.it1315.tree.service.impl;

import com.it1315.tree.entity.Tree;
import com.it1315.tree.mapper.TreeMapper;
import com.it1315.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by dly on 2018/10/8
 */
@Service(value = "treeService")
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> findTreeById(Integer id) {
        return treeMapper.findById(id);
    }

    @Override
    public List<Tree> findTreeWithCondition(Map<String, Object> map) {
        return treeMapper.findWithCondition(map);
    }
}
