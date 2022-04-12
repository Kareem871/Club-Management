package com.club.web;

import com.club.Repositories.Stat;
import com.club.Repositories.statRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;


@Slf4j
@Controller
@RequestMapping(value = "/stat")
public class statController {
    @Autowired
    private statRepository sr;

    @GetMapping
    public String stat(Model model, String date) throws ParseException {
        if (date != null){
            int month = Integer.parseInt(date.split("-")[1]);
            int year = Integer.parseInt(date.split("-")[0]);
            List<Stat> report = sr.getReport(month, year);
            log.info("month and year not null  " + report);
            model.addAttribute("report", report);
        }
        else {
            List<Stat> report = sr.getAll();
            log.info("Report: " + report.toString());
            model.addAttribute("report", report);
        }
        return "stat";
    }
}
