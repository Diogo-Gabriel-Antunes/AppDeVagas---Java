package br.com.geekhunter.demo.DTO.Candidate;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import lombok.Data;

import java.util.Date;

@Data
public class CandidateDTO {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Curriculum curriculum;



    public Candidate convert() {
        return new Candidate(this.nome,this.cpf,this.dataNascimento,this.curriculum);
    }
}
