package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface renewRepository extends CrudRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname c where c.id = :id and c.active = '1'", nativeQuery = true)
    newCustomer findByIdAndActive(@Param("id")UUID id);

    @Query(value = "select * from clubname c where c.name = :name and c.active = '1'", nativeQuery = true)
    newCustomer findByNameAndActive(@Param("name") String name);

    @Query(value = "select cast(id as varchar) from clubname c where c.name = :name and c.active = '1'", nativeQuery = true)
    UUID findIdbyName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO clubname (id, name, money, date, period, mobileno, active, type) " +
            "VALUES (uuid_generate_v4(), :#{#nc.name}, :#{#nc.money}, :#{#nc.date}, :#{#nc.period}," +
            " :#{#nc.mobileno}, true, :#{#nc.type})", nativeQuery = true)
    void insertNew(@Param("nc") newCustomer nc);

    @Transactional
    @Modifying
    @Query(value = "UPDATE clubname SET active='0' where id = :id", nativeQuery = true)
    void updateStatus(@Param("id")UUID id);

}
