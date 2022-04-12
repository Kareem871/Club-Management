package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface newRepository extends CrudRepository<newCustomer, UUID> {

    @Query(value = "select * from clubname c where c.name = :name and c.active='1' and c.type = :type", nativeQuery = true)
    List<newCustomer> findByNameAndActive(@Param("name") String name, @Param("type") Boolean type);

    @Query(value = "select count(*) from clubname c where c.name = :name and c.active='1' and c.type = :type", nativeQuery = true)
    int findByCountNameAndActive(@Param("name") String name, @Param("type") Boolean type);


    @Query(value = "select active from clubname c where c.id = :id", nativeQuery = true)
    boolean findStatus(@Param("id")UUID id);
}
