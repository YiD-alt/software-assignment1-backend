package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.Params;
import com.example.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.selectAll();
    }

    public PageInfo<User> findBySearch(Params params){
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        List<User> list= userDao.findBySearch(params);
        return PageInfo.of(list);
    }

    public void add(User user) {
        if(user.getPassword()==null){
            user.setPassword("123456");
        }
        userDao.insertSelective(user);
    }

    public void update(User user){
        userDao.updateByPrimaryKeySelective(user);
    }

    public void delete(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }
}