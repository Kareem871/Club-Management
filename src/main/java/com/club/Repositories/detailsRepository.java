package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface detailsRepository extends CrudRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname s where s.name = :name", nativeQuery = true)
    List<newCustomer> findByName(@Param("name")String name);

    @Query(value = "select name from clubname c where c.id = :id", nativeQuery = true)
    String findNameById(@Param("id") UUID id);
}
