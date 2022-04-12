package com.club.web;

import com.club.newCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface pageRepository extends PagingAndSortingRepository<newCustomer, UUID> {
    @Query(value = "select * from clubname c where c.active = '0'", nativeQuery = true)
    Page<newCustomer> findAllInactive(Pageable pageable);

    @Query(value = "select * from clubname c where c.active = '1'", nativeQuery = true)
    Page<newCustomer> findByActive(Pageable pageable);

    @Query(value = "select * from clubname c where lower(c.name) like %:name% and c.active = '1'", nativeQuery = true)
    Page<newCustomer> findByNameAndActive(@Param("name")String name, Pageable pageable);

    @Query(value = "select * from clubname c where lower(c.name) like %:name% and c.active = '0'", nativeQuery = true)
    Page<newCustomer> findByInactive(@Param("name") String name, Pageable pageable);
}
