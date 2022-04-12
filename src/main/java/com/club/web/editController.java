package com.club.web;

import com.club.Repositories.editRepository;
import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/edit")
public class editController {
    @Autowired
    private editRepository er;

    @GetMapping(value = "/{id}")
    public String EditPage(Model model, @PathVariable("id") String id){
        log.info("id: " + id);
        log.info(er.findByIdAndActive(UUID.fromString(id)).toString());
        model.addAttribute("user", er.findByIdAndActive(UUID.fromString(id)));
        return "edit";
    }

    @PostMapping(params = "cancel")
    public String cancel(){
        return "redirect:/view";
    }

    @PostMapping(params = "submit", value = "{id}")
    public String submit(newCustomer nc, @PathVariable("id")String id){
        log.info("To Edit: " + nc);

        nc.setId(UUID.fromString(id));
        nc.setExpiry(nc.getDate().plusMonths(nc.getPeriod()));
        er.save(nc);

        return "redirect:/view";
    }
}
