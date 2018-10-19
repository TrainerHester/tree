package com.it1315.tree.controller;

import com.it1315.tree.entity.Tree;
import com.it1315.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dly on 2018/10/8
 */
@RestController
public class HelloController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("/trees")
    public List<Tree> hello() {
        return treeService.findTreeWithCondition(new HashMap<>());
    }

}
