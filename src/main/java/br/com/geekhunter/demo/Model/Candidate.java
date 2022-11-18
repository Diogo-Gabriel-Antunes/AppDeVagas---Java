package br.com.geekhunter.demo.Model;

import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "curriculum")
    private Curriculum curriculum;
    private String category;
    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User userId;

    public Candidate() {
    }

    public Candidate(String nome, String cpf, Date dataNascimento, Curriculum curriculum) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.curriculum = curriculum;
    }

}
