/**
 * Copyright (c) 2025 by Jonathan KABONGA
 *
 * @Author: Jonathan KABONGA
 * @Date: 19/04/2025
 * @Time: 05:00
 */

package com.codex.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity

public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private long tempsApprentissageMs; //Temps en millisecondes

    public LocalDate getDateFin() {
        return dateFin;
    }

    public long getTempsApprentissageMs() {
        return tempsApprentissageMs;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setTempsApprentissageMs(long tempsApprentissageMs) {
        this.tempsApprentissageMs = tempsApprentissageMs;
    }
}
