package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface editRepository extends CrudRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname s where s.id = :id and s.active = '1'", nativeQuery = true)
    newCustomer findByIdAndActive(@Param("id")UUID id);
    @Query(value = "select type from clubname c where c.name = :name and c.active = '1'", nativeQuery = true)
    boolean findType(@Param("name")String name);
    @Query(value = "select cast(id as varchar) from clubname c where c.name = :name " +
            "and c.type = :type and c.active = '1'", nativeQuery = true)
    UUID findIdbyName(@Param("name") String name, @Param("type") Boolean type);
}
