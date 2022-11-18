package br.com.geekhunter.demo.DTO.curriculum;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Curriculum.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
public class CreateCurriculumDto{
    private List<ProfessionalExperience> professionalExperience;
    private List<Formation> formations;
    private List<Skills> skills;
    private List<Language> languages;
    private List<Links> links;
    private Candidate candidate;
    private String description;
    private String email;
    private String telephone;
    private String nome;
    private Integer age;
    private LocalDate birthDate;
    private Integer progress;

    public Curriculum convert() {
        return new Curriculum(this.professionalExperience,this.birthDate,this.candidate,this.email,this.description,this.formations,this.telephone,this.nome,this.skills,this.languages,this.links,this.age);
    }
}