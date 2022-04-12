package com.club.web;

import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class pageService {
    @Autowired
    private pageRepository pr;

    public Page<newCustomer> getAll(int pageNo){
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("expiry"));
        Page<newCustomer> allactive = pr.findByActive(pageable);
        log.info("All Active: " + allactive);
        return allactive;
    }
    public Page<newCustomer> getInactive(int pageNo){
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("expiry"));
        Page<newCustomer> allinctive = pr.findAllInactive(pageable);
        log.info("All Inactive: " + allinctive);
        return allinctive;
    }
    public Page<newCustomer> getActiveName(int pageNo, String name){
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("expiry"));
        Page<newCustomer> activeName = pr.findByNameAndActive(name, pageable);
        log.info("Active By Name: " + activeName);
        return activeName;
    }

    public Page<newCustomer> getInactiveName(int pageNo, String name){
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("expiry"));
        Page<newCustomer> incativename = pr.findByInactive(name, pageable);
        log.info("Inactive By Name: " + incativename);
        return incativename;
    }

}
