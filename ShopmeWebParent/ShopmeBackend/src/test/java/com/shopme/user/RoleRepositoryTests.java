package com.shopme.user;

import com.shopme.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTests {
    @Autowired
    private RoleRepository rolerepository;

    @Test
    public void testCreateAdminRole(){
        Role adminRole = new Role("ADMIN", "Mange everything");
        rolerepository.save(adminRole);
        assertThat(adminRole.getId()).isGreaterThan(0);
    }

}
