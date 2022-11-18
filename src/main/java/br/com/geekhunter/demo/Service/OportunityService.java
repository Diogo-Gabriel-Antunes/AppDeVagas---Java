package br.com.geekhunter.demo.Service;

import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Curriculum.Skills;
import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.repository.CandidateRepository;
import br.com.geekhunter.demo.repository.VacanciesRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OportunityService {

    public Set<Vacancies> criaListaDeOportunidades(CandidateRepository candidateRepository, VacanciesRepository vacanciesRepository, Long id) {
        Candidate candidate = candidateRepository.findById(id).get();
        List<Skills> skills = candidate.getCurriculum().getSkills();
        Set<Vacancies> opportunity = new HashSet<>();
        for (Skills skill:skills) {
            List<Vacancies> vacanciesByTechnologiesRequired = vacanciesRepository.getVacanciesByTechnologiesRequiredAndActive(skill.getTechnologies(),true);
            for (Vacancies vacancies: vacanciesByTechnologiesRequired) {
                opportunity.add(vacancies);
            }
        }
        return opportunity;
    }
}
