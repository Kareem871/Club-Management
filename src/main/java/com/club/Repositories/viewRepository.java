package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface viewRepository extends CrudRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname c where lower(c.name) like %:name% and c.active = '1'", nativeQuery = true)
    List<newCustomer> findByNameAndActive(@Param("name")String name);

    @Query(value = "select * from clubname c where c.active = '1'", nativeQuery = true)
    List<newCustomer> findByActive();

    @Query(value = "select * from clubname c where lower(c.name) like %:name% and c.active = '0'", nativeQuery = true)
    List<newCustomer> findByInactive(@Param("name") String name);

    @Query(value = "select * from clubname c where c.active = '0'", nativeQuery = true)
    List<newCustomer> findAllInactive();

}
