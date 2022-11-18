package br.com.geekhunter.demo.Model.Curriculum;

import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professional_experience")
@Getter
@Setter
public class ProfessionalExperience {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "curriculum")
    @JsonIgnore
    private Curriculum curriculum;
    @OneToMany(mappedBy = "professionalExperience")
    private List<Activity> activity;
    private String city;
    private String office;
    private String companyName;
    private String startYear;
    private String endYear;

}