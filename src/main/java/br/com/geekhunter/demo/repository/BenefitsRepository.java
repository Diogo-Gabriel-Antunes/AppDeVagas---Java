package br.com.geekhunter.demo.repository;

import br.com.geekhunter.demo.Model.Benefits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitsRepository extends JpaRepository<Benefits, Long> {
}
