package br.com.geekhunter.demo.DTO.curriculum;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Curriculum.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UpdateCurriculumDTO {
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
    private LocalDate birthDate;
    private Integer age;
    private Integer progress;

    public Curriculum convert(Curriculum curriculum) {
        if (professionalExperience != null) {
            curriculum.setProfessionalExperience(this.professionalExperience);
        }
        if (formations != null) {
            curriculum.setFormations(this.formations);
        }
        if (skills != null) {
            curriculum.setSkills(this.skills);
        }
        if (languages != null) {
            curriculum.setLanguages(this.languages);
        }
        if (links != null) {
            curriculum.setLinks(this.links);
        }
        if (candidate != null) {
            curriculum.setCandidate(this.candidate);
        }
        if (description != null) {
            curriculum.setDescription(this.description);
        }
        if (email != null) {
            curriculum.setEmail(this.email);
        }
        if (telephone != null) {
            curriculum.setTelephone(this.telephone);
        }
        if (nome != null) {
            curriculum.setNome(this.nome);
        }
        if (birthDate != null) {
            curriculum.setBirthDate(this.birthDate);
        }
        if(age != null){
            curriculum.setAge(this.age);
        }
        curriculum.calculeteProgress();
        return curriculum;
    }
}
