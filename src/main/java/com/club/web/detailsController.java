package com.club.web;

import com.club.Repositories.detailsRepository;
import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/details")
public class detailsController {
    @Autowired
    private detailsRepository dr;

    @GetMapping(value = "/{id}")
    public String details(Model model, @Param("id")String id, newCustomer nc){
        String name = dr.findNameById(nc.getId());
        log.info("Details: " + dr.findByName(name));
        model.addAttribute("views", dr.findByName(name));
        return "details";
    }
}
