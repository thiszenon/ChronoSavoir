/**
 * Copyright (c) 2025 by Jonathan KABONGA
 *
 * @Author: Jonathan KABONGA
 * @Date: 19/04/2025
 * @Time: 05:16
 */

package com.codex.demo.service;

import com.codex.demo.model.Competence;
import com.codex.demo.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceService(CompetenceRepository repository){
        this.competenceRepository = repository;
    }

    /*
    Sauvegarder une nouvelle competence
     */
    public Competence saveCompetence(Competence competence){
        if(competence.getDateDebut() == null){
            competence.setDateDebut(LocalDate.now()); //date debut automatique
        }
        return competenceRepository.save(competence);
    }

    /*
    Liste de toutes les competences
     */
    public List<Competence> findAll(){
        return competenceRepository.findAll();
    }

    /*
    Trouver une competence par son Id
    Methode util pour la mise à jour d'une competence
     */
    public Optional<Competence> findById(Long id){
        return competenceRepository.findById(id);
    }

    /*
    Ajouter du temps d'apprentissage à une competence
     */
    public  void addLearningTime(Long competenceId, long duration){
        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow( ()-> new RuntimeException("Compétence non trouvée"));
        competence.setTempsApprentissageMs(
                competence.getTempsApprentissageMs() + duration
        );
        competenceRepository.save(competence);
    }

    /*
    Supprimer une competence
     */
    public void deleteCompetence(Long id){
        competenceRepository.deleteById(id);
    }
}
