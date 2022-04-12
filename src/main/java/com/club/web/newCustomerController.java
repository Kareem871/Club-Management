package com.club.web;

import com.club.newCustomer;
import com.club.Repositories.newRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/new")
public class newCustomerController {
    @Autowired
    private newRepository nr;

    @GetMapping
    public String NewPage (Model model){
        model.addAttribute("newCustomer", new newCustomer());
        return "new";
    }

    @PostMapping
    public String add(@Valid newCustomer nc, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "new";
        }
        log.info(nc + "\nReceived Type: " + nc.getType() );
        log.info("\nReal Type: " + nr.findByNameAndActive(nc.getName(), nc.getType()));
        if (nc.getType() && nc.getPeriod() <= 0){
            model.addAttribute("periodError", "Period can't be 0 or less");
            return "new";
        }

        if (nr.findByCountNameAndActive(nc.getName(), nc.getType()) == 0 || !nc.getType()) {
            if (nc.getType()) nc.setExpiry(nc.getDate().plusMonths(nc.getPeriod()));
            if (!nc.getType()) nc.setExpiry(nc.getDate());
            nr.save(nc);
        }
        else {
            model.addAttribute("nameError", "Name already exists");
            return "new";
        }

//        log.info("New Member: " +  nc);
        return "redirect:/";
    }
}
