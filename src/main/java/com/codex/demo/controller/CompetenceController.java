/**
 * Copyright (c) 2025 by Jonathan KABONGA
 *
 * @Author: Jonathan KABONGA
 * @Date: 19/04/2025
 * @Time: 05:14
 */

package com.codex.demo.controller;

import com.codex.demo.service.CompetenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/skills")
public class CompetenceController {
    private CompetenceService competenceService;



    @GetMapping("/")
    public String listeCompetences(Model model){
        model.addAttribute("skills",competenceService.findAll());
        return "index"; //index.html dans templates
    }

    @PostMapping("/{id}/add-time")
    public ResponseEntity<String> addTime(@PathVariable Long id, @RequestParam long duration){
        competenceService.addLearningTime(id,duration);
        return ResponseEntity.ok("Temps ajouté");
    }
}
