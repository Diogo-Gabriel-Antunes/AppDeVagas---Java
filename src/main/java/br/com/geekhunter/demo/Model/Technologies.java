package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String technologies;
    private String category;
    @JsonIgnore
    @ManyToMany(mappedBy = "technologiesRequired")
    private Set<Vacancies> vacanciesRequired;
    @JsonIgnore
    @ManyToMany(mappedBy = "technologiesDesirable")
    private Set<Vacancies> vacanciesDesirable;

    public Technologies() {
    }

    public Technologies(String technologies, String category) {
        this.technologies = technologies;
        this.category = category;
    }

    public Set<Vacancies> getVacanciesRequired() {
        return vacanciesRequired;
    }

    public void setVacanciesRequired(Set<Vacancies> vacanciesRequired) {
        this.vacanciesRequired = vacanciesRequired;
    }

    public Set<Vacancies> getVacanciesDesirable() {
        return vacanciesDesirable;
    }

    public void setVacanciesDesirable(Set<Vacancies> vacanciesDesirable) {
        this.vacanciesDesirable = vacanciesDesirable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
