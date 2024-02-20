package com.shopme.user;

import com.shopme.entity.Role;
import jakarta.persistence.Id;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

@Repository

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
