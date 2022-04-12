package com.club.Repositories;

import com.club.User;
import org.springframework.data.repository.CrudRepository;


import javax.persistence.Id;

public interface userRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
