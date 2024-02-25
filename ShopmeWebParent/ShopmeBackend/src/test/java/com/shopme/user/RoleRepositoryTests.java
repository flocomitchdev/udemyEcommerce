package com.shopme.user;

import com.shopme.admin.user.RoleRepository;
import com.shopme.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository rolerepository;

    @Test
    public void testCreateAdminRole(){
        Role adminRole = new Role("ADMIN", "Manage everything");
        rolerepository.save(adminRole);
        assertThat(adminRole.getId()).isGreaterThan(0);
    }

}
