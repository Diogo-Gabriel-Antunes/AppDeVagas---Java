package br.com.geekhunter.demo.Model.Curriculum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "language")
@Getter
@Setter
public class Language {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "curriculum")
    @JsonIgnore
    private Curriculum curriculum;
    private String linguage;
    @Enumerated(EnumType.STRING)
    private Level level;

}