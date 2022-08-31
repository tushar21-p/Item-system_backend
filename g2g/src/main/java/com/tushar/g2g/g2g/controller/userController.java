package com.tushar.g2g.g2g.controller;


import com.tushar.g2g.g2g.entity.User;
import com.tushar.g2g.g2g.model.userModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/host/v1/")
public class userController {

    @Autowired
    private com.tushar.g2g.g2g.services.userServices userServices;

    public userController(com.tushar.g2g.g2g.services.userServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/items")
    public userModel postItem(@RequestBody userModel userModel){
         return userServices.postItem(userModel);

    }
    @GetMapping("/items")
    public List<userModel> getAll(){
        return userServices.getAll();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<userModel> getAllById(@PathVariable Long id){
        userModel userModel = null;
         userModel = userServices.getAllById(id);
         return ResponseEntity.ok(userModel);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id){
        boolean deleted = false;
        deleted = userServices.deleteItem(id);
        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/items/{id}")
    public User updateByid(@PathVariable Long id, @RequestBody Map<Object, Object> objectMap){
        return userServices.updateByid(id, objectMap);

    }

}
