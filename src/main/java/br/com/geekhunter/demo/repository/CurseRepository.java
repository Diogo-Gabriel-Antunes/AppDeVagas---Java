package br.com.geekhunter.demo.repository;

import br.com.geekhunter.demo.Model.Curse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurseRepository extends JpaRepository<Curse, Long> {
}