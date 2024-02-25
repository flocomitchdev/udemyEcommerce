package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {userRepository.save(user);
    }

    public List<Role> listAllROles(){
        return (List<Role>)roleRepository.findAll();
    }
}
