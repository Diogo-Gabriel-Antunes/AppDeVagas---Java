package br.com.geekhunter.demo.Model.Curriculum;

import br.com.geekhunter.demo.Model.Candidate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 9999999)
    private String description;
    private String email;
    private String telephone;
    private String nome;
    private LocalDate birthDate;
    private Integer age;
    private Integer progress = 0;
    @OneToMany(mappedBy = "curriculum")
    private List<ProfessionalExperience> professionalExperience;
    @OneToMany(mappedBy = "curriculum")
    private List<Formation> formations;
    @OneToMany(mappedBy = "curriculum")
    private List<Skills> skills;
    @OneToMany(mappedBy = "curriculum")
    private List<Language> languages;
    @OneToMany(mappedBy = "curriculum")
    private List<Links> links;
    @OneToOne(mappedBy = "curriculum")
    @JsonIgnore
    private Candidate candidate;


    public Curriculum(List<ProfessionalExperience> professionalExperience, LocalDate birthDate, Candidate candidate, String email, String description, List<Formation> formations, String telephone, String nome, List<Skills> skills, List<Language> languages, List<Links> links, Integer age) {
        this.professionalExperience = professionalExperience;
        this.formations = formations;
        this.skills = skills;
        this.languages = languages;
        this.links = links;
        this.candidate = candidate;
        this.description = description;
        this.email = email;
        this.telephone = telephone;
        this.nome = nome;
        this.birthDate = birthDate;
        this.age = age;
        calculeteProgress();
    }

    public Curriculum() {
    }

    public void calculeteProgress() {
        double progress = 0;
        if (professionalExperience != null) {
            progress += 10;
        }
        if (formations != null) {
            progress += 10;
        }
        if (skills != null) {
            progress += 10;
        }
        if (languages != null) {
            progress += 10;
        }
        if (links != null) {
            progress += 10;
        }
        if (description != null) {
            progress += 10;
        }

        if (email != null) {
            progress += 10;
        }
        if (telephone != null) {
            progress += 10;
        }
        if (nome != null) {
            progress += 10;
        }
        if (birthDate != null) {
            progress += 10;
        }
        if(age != null){
            progress += 10;
        }
        setProgress((int) progress);
    }
}
