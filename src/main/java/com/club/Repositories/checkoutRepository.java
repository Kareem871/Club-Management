package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface checkoutRepository extends CrudRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname s where s.id = :id and s.active = '1'", nativeQuery = true)
    newCustomer findByIdAndActive(@Param("id")UUID id);
}
