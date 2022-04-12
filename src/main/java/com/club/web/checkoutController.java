package com.club.web;

import com.club.Repositories.checkoutRepository;
import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = "/checkout")
public class checkoutController {
    @Autowired
    private checkoutRepository cor;

    @GetMapping(value = "/{id}")
    public String checkout(newCustomer nc, @PathVariable("id") String id){
        nc = cor.findByIdAndActive(nc.getId());
//        log.info("To Set: " + nc.getName());
        nc.setActive(false);
        log.info("To Set: " + nc);
        cor.save(nc);
        return "redirect:/view";
    }
}
