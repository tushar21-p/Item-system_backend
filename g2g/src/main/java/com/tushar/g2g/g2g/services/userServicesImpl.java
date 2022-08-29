package com.tushar.g2g.g2g.services;


import com.tushar.g2g.g2g.entity.User;
import com.tushar.g2g.g2g.model.userModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class userServicesImpl implements userServices{
    @Autowired
    private com.tushar.g2g.g2g.repositories.userRepositories userRepositories;
    @Override
    public userModel postItem(userModel userModel) {
        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        userRepositories.save(user);
        return userModel;
    }

    @Override
    public List<userModel> getAll() {
        List<User> users = userRepositories.findAll();
        List<userModel> userModels = users.stream().map(user -> new userModel(user.getId(),
                                                                                user.getName(),
                                                                                user.getPrice(),
                                                                                user.getDescription(),
                                                                                user.isAvailable())).collect(Collectors.toList());
        return userModels;
    }

    @Override
    public userModel getAllById(Long id) {
        User user = userRepositories.findById(id).get();
        userModel userModel = new userModel();
        BeanUtils.copyProperties(user, userModel);
        return userModel;
    }

    @Override
    public boolean deleteItem(Long id) {
        User user = userRepositories.findById(id).get();
        userRepositories.delete(user);
        return true;

    }

    @Override
    public User updateByid(Long id, Map<Object, Object> objectMap) {
        User user = userRepositories.findById(id).get();
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, value);
        });
        return userRepositories.save(user);

    }


}

