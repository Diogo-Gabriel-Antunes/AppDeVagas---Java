package br.com.geekhunter.demo.Service;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.repository.CandidateRepository;
import br.com.geekhunter.demo.repository.VacanciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ApplicationService {


    public List<Vacancies> criaListaDeVagasAplicadas(VacanciesRepository vacanciesRepository, Long id, CandidateRepository candidateRepository) {
        Candidate candidate = candidateRepository.findById(id).get();
        List<Vacancies> vacanciesByCandidato = vacanciesRepository.getVacanciesByCandidato(candidate);
        return vacanciesByCandidato;
    }
}
