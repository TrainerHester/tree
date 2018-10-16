package com.it1315.tree;

import com.it1315.tree.entity.Tree;
import com.it1315.tree.service.TreeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeApplicationTests {

    @Autowired
    TreeService treeService;

    @Test
    public void contextLoads() {
        List<Tree> trees = treeService.findTreeById(2);
        System.out.println(trees.get(0));
    }

}
