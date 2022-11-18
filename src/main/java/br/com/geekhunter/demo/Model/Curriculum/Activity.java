package br.com.geekhunter.demo.Model.Curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "activity")
@Getter
@Setter
public class Activity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String activity;
    @ManyToOne
    @JoinColumn(name = "professionalExperience")
    @JsonIgnore
    private ProfessionalExperience professionalExperience;
}