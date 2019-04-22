package com.it1315.tree.repository;

import com.it1315.tree.entity.FieldConfigEntity;
import com.it1315.tree.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class ConfigRepository {

    private HashMap<String, FieldConfigEntity> FieldConfigEntityList = new HashMap<>();
    private ArrayList<FieldConfigEntity> PKArrayList = new ArrayList<>();
    private HashMap<Long, User> UserEntityList = new HashMap<>();

    public void addFiledConfig(FieldConfigEntity entity) {
        FieldConfigEntityList.put(entity.getFieldName(), entity);
    }

    public void addUser(User user) {
        UserEntityList.put(user.getUserCode(), user);
    }



}
