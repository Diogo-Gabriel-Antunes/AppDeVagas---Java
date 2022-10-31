package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Benefits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String benefits;
    @ManyToMany(mappedBy = "benefits")
    @JsonIgnore
    private Set<Vacancies> vacancies;

    public Benefits(String benefits) {
        this.benefits = benefits;
    }

    public Benefits() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Set<Vacancies> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancies> vacancies) {
        this.vacancies = vacancies;
    }
}
