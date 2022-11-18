package br.com.geekhunter.demo.DTO.Candidate;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import br.com.geekhunter.demo.repository.CandidateRepository;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateCandidateDTO {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Curriculum curriculum;



    public Candidate updateCandidate(Long id, CandidateRepository candidateRepository) {
        Candidate candidate = candidateRepository.findById(id).get();
        candidate.setNome(this.nome);
        candidate.setCpf(this.cpf);
        candidate.setCurriculum(this.curriculum);
        candidate.setDataNascimento(this.dataNascimento);
        return candidate;
    }
}
