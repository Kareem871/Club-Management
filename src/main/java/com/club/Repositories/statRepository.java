package com.club.Repositories;

import com.club.newCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface statRepository extends CrudRepository<newCustomer, UUID> {

    @Query(value = "select EXTRACT(YEAR from date) as Year, EXTRACT(MONTH from date) as Month, Count(name) as Visitors, SUM(money) from clubname " +
            "where EXTRACT(MONTH from date) = :month and EXTRACT(YEAR from date) = :year group by Year, Month", nativeQuery = true)
    List<Stat> getReport(@Param("month") int month, @Param("year") int year);

    @Query(value = "select EXTRACT(YEAR from date) as year, EXTRACT(MONTH from date) as month,Count(name) as visitors, SUM(money) as sum from clubname " +
            "group by year, month", nativeQuery = true)
    List<Stat> getAll();
}
