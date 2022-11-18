package br.com.geekhunter.demo.repository;

import br.com.geekhunter.demo.Model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate getCandidateByUserId_CandidateId(Long id);
}
