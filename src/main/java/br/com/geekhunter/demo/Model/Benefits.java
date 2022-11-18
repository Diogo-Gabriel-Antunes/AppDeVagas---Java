package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
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

}
