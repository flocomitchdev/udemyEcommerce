package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void createRole(){
        List<Role> allRoles = new ArrayList<>();
        Role adminRole = new Role("ADMIN", "Manage everything");
        Role standardRole = new Role("USER", "Standard role");

        allRoles.add(adminRole);
        allRoles.add(standardRole);

        roleRepository.saveAll(allRoles);
    }
}
