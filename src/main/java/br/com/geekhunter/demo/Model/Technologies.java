package br.com.geekhunter.demo.Model;

import br.com.geekhunter.demo.Model.Curriculum.Skills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String technologies;
    private String category;
    @ManyToMany(mappedBy = "technologiesRequired")
    @JsonIgnore
    private Set<Vacancies> vacanciesRequired;
    @ManyToMany(mappedBy = "technologiesDesirable")
    @JsonIgnore
    private Set<Vacancies> vacanciesDesirable;

    @OneToOne(mappedBy = "technologies")
    @JsonIgnore
    private Curse curse;
    @OneToOne(mappedBy = "technologies")
    @JsonIgnore
    private Skills skills;
    public Technologies() {
    }

    public Technologies(String technologies, String category) {
        this.technologies = technologies;
        this.category = category;
    }



}
