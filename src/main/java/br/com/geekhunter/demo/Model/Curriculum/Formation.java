package br.com.geekhunter.demo.Model.Curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "formation")
@Getter
@Setter
public class Formation {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "curriculum")
    @JsonIgnore
    private Curriculum curriculum;
    private String titleFormation;
    private String levelOfTraining;
    private String institution;

}