package com.tushar.g2g.g2g.services;

import com.tushar.g2g.g2g.entity.User;
import com.tushar.g2g.g2g.model.userModel;

import java.util.List;
import java.util.Map;

public interface userServices {
    userModel postItem(userModel userModel);

    List<userModel> getAll();

    userModel getAllById(Long id);

    boolean deleteItem(Long id);

    User updateByid(Long id, Map<Object, Object> objectMap);
}
