package br.com.geekhunter.demo.repository;

import br.com.geekhunter.demo.Model.Technologies;
import br.com.geekhunter.demo.Model.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies, Long> {
    List<Vacancies> findByActive(Boolean active);

    List<Vacancies> findByTechnologiesRequired(Technologies technologies);
}