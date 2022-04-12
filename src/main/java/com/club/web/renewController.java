package com.club.web;

import com.club.Repositories.renewRepository;
import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/renew")
public class renewController {
    @Autowired
    private renewRepository rr;

    @GetMapping(value = "/{id}")
    public String renew(Model model, @PathVariable("id") String id){
        log.info("id: " + id);
//        log.info(er.findByIdAndActive(UUID.fromString(id)).toString());
        model.addAttribute("user", rr.findByIdAndActive(UUID.fromString(id)));
        return "renew";
    }
    @PostMapping(params = "cancel")
    public String cancel(){
        return "redirect:/view";
    }

    @PostMapping(params = "submit")
    public String submit(newCustomer nc){
        log.info("To Renew: " + nc);
        rr.updateStatus(rr.findIdbyName(nc.getName()));
        log.info("Status Updated");
        rr.insertNew(nc);
        log.info("Added New");

        return "redirect:/view";
    }

}
