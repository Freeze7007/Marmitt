package com.hsma.uebung2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    private DBController db;

    public WebController(){
        db = new DBController();
    }

    @GetMapping("/")
    public String rezeptListe(Model model) {
        HashMap<Integer, Rezept> rezeptMap = db.getAllRezepte();
        model.addAttribute("Titel", "Rezept.de");
        model.addAttribute("RezeptMap", rezeptMap);

        return "index";
    }

    @GetMapping("/rezept/{id}")
    public String rezept(@PathVariable int id, Model model) {
        Rezept rezept = db.getRezept(id);
        model.addAttribute("rezept", rezept);

        return "rezept";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Max Mustermann");
        model.addAttribute("alter", "21");
        model.addAttribute("semester", "2");
        model.addAttribute("studiengang", "UIB");
        return "about";
    }
}
