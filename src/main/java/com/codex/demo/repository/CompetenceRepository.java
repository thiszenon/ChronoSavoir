package com.codex.demo.repository;

import com.codex.demo.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence,Long>{
    List<Competence> findByTitreContaining(String motCle);
    //void saveCompetence(Competence competence);
    //void deleteCompetence(Long id);
    //Competence findCompetence(String motCle);

}
