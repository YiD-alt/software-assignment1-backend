package com.example.controller;

import com.example.common.Result;
import com.example.entity.Params;
import com.example.entity.User;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userservice;

    @PostMapping
    public Result save(@RequestBody User user){
        if(user.getId()==null){
            userservice.add(user);
        }else{
            userservice.update(user);
        }

        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<User> list = userservice.findAll();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<User> info= userservice.findBySearch(params);
        return Result.success(info);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        userservice.delete(id);
        return Result.success();
    }
}
