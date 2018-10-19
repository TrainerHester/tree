package com.it1315.tree.controller;

import com.it1315.tree.entity.Tree;
import com.it1315.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dly on 2018/10/8
 *
 */
@RestController
@RequestMapping("/trees")
public class HelloController {

    @Autowired
    private TreeService treeService;

    public List<Tree> getAll() {
        return treeService.findTreeWithCondition(new HashMap<>());
    }
    @RequestMapping("test")
    public void testJacksonList(@RequestParam("alps") List<String> alps) {
        System.out.println(alps);
    }

    @RequestMapping("search")
    public List<Tree> getCustomedAll(
            @RequestParam(required = false, name = "minAge") Integer minAge, @RequestParam(required = false, name = "maxAge") Integer maxAge,
            @RequestParam(required = false, name = "minHight") Double minHight, @RequestParam(required = false, name = "maxHight") Double maxHight,
            @RequestParam(required = false, name = "treeType") List<String> typeList)

    {
        HashMap<String, Object> parMap = new HashMap<>();
        parMap.put("minAge", minAge);
        parMap.put("maxAge", maxAge);
        parMap.put("treeTypes", typeList);
        return treeService.findTreeWithCondition(parMap);
    }


}
