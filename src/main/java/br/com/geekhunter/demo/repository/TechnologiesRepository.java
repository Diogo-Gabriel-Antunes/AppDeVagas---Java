package br.com.geekhunter.demo.repository;

import br.com.geekhunter.demo.Model.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologiesRepository extends JpaRepository<Technologies, Long> {
}