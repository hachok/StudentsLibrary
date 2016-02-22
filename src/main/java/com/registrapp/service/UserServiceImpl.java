package com.registrapp.service;

import com.registrapp.dao.UserDao;
import com.registrapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        user.setSsoId(new Random(System.currentTimeMillis()).nextInt(1000000) + 10000);
        user.setUser_role_id(1);
        user.setAccount_status("disabled");
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = userDao.getUserById(user.getId());
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setFirstname(user.getFirstname());
            entity.setLastname(user.getLastname());
            entity.setEmail(user.getEmail());
            entity.setUserFiles(user.getUserFiles());
            entity.setAccount_status(user.getAccount_status());
            entity.setUser_role_id(user.getUser_role_id());
            entity.setPassword(user.getPassword());
        }
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}