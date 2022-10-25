package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Technologies {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String technologies;
    private String category;
    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private Set<Vacancies> vacancies;

    public Technologies() {
    }

    public Technologies(String technologies, String category) {
        this.technologies = technologies;
        this.category = category;
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

    public Set<Vacancies> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancies>  vacancies) {
        this.vacancies = vacancies;
    }
}
