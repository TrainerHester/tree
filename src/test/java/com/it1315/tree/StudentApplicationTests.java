package com.it1315.tree;

import com.it1315.tree.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dly on 2018/10/29
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void selectByPrimaryKeyTest() {
        Integer id = -1;
        System.out.println(studentMapper.selectByPrimaryKey(id));

    }

}
