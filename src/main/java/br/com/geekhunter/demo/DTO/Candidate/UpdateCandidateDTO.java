package br.com.geekhunter.demo.DTO.Candidate;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.repository.CandidateRepository;

import java.util.Date;

public class UpdateCandidateDTO {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String curriculo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public Candidate updateCandidate(Long id, CandidateRepository candidateRepository) {
        Candidate candidate = candidateRepository.findById(id).get();
        candidate.setNome(this.nome);
        candidate.setCpf(this.cpf);
        candidate.setCurriculo(this.curriculo);
        candidate.setDataNascimento(this.dataNascimento);
        return candidate;
    }
}
