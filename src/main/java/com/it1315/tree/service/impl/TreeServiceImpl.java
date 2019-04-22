package com.it1315.tree.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.it1315.tree.entity.Tree;
import com.it1315.tree.mapper.TreeMapper;
import com.it1315.tree.service.TreeService;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dly on 2018/10/8
 */
@Service(value = "treeService")
public class TreeServiceImpl implements TreeService {


//    @Autowired

//
//    @Override
//    public List<Tree> findTreeById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<Tree> findTreeWithCondition(Map<String, Object> map) {
//        return null;
//    }
//










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
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    public String TreeDataHandler(Map<String, String> queryMap){
//        String httpRes = restTemplate.getForObject(
//                UIProperties.getConfig().getTreeData().getURL(),
//                String.class,
//                queryMap);
//        return new HttpResParser(httpRes);
//    }


}
