package com.club.web;

import com.club.newCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/view")
public class viewController {
    @Autowired
    private pageService ps;

    @GetMapping
    public String viewPage(@RequestParam(defaultValue = "0") int pageNo, Model model, String keyword, boolean inactive) {
        if (inactive && (keyword == null || keyword.isEmpty())) {
            log.info("Here");
            Page<newCustomer> page = ps.getInactive(pageNo);
            log.info("Page Details: " + page);
            List<newCustomer> list = page.getContent();
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalRecords", page.getTotalElements());
            model.addAttribute("views", list);
            model.addAttribute("inactive", true);
            return "view";
        }

        if (!inactive && (keyword == null || keyword.isEmpty())) {
            log.info("Normal way");
            Page<newCustomer> page = ps.getAll(pageNo);
            List<newCustomer> list = page.getContent();
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalRecords", page.getTotalElements());
            model.addAttribute("views", list);
            model.addAttribute("inactive", false);
            return "view";
        }
        if (!inactive && keyword != null) {
            log.info("Normal way");
            Page<newCustomer> page = ps.getActiveName(pageNo, keyword);
            List<newCustomer> list = page.getContent();
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalRecords", page.getTotalElements());
            model.addAttribute("views", list);
            model.addAttribute("inactive", false);
            return "view";
        }

        if (inactive && keyword != null) {
            log.info("Normal way");
            Page<newCustomer> page = ps.getInactiveName(pageNo, keyword);
            List<newCustomer> list = page.getContent();
            model.addAttribute("currentPage", pageNo);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalRecords", page.getTotalElements());
            model.addAttribute("views", list);
            model.addAttribute("inactive", true);
            return "view";
        }

        return "error";
    }
}