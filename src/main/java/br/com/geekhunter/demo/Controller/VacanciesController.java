package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.vacancies.CreateVacanciesDTO;
import br.com.geekhunter.demo.DTO.vacancies.UpdateVacanciesDTO;
import br.com.geekhunter.demo.Model.Technologies;
import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.repository.VacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RequestMapping("/vacancies")
@RestController
public class VacanciesController {

    @Autowired
    private VacanciesRepository vacanciesRepository;

    @GetMapping
    public List<Vacancies> listVacancies() {
        List<Vacancies> vacancies = vacanciesRepository.findByActive(true);
        return vacancies;
    }

    @GetMapping("/{id}")
    public Vacancies detailsVacancies(@PathVariable Long id) {
        Vacancies vacancies = vacanciesRepository.findById(id).get();

        return vacancies;
    }

    @PostMapping
    public ResponseEntity<Vacancies> register(@RequestBody CreateVacanciesDTO createVacanciesDTO) {
        Vacancies vacancies = createVacanciesDTO.convert();

        vacanciesRepository.save(vacancies);
        URI uri = UriComponentsBuilder.fromPath("/company/{id}").buildAndExpand(vacancies.getId()).toUri();


        return ResponseEntity.created(uri).body(vacancies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Vacancies vacancies = vacanciesRepository.findById(id).get();
        if (vacancies == null) {
            return ResponseEntity.badRequest().build();
        } else {
            vacanciesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Vacancies> update(@PathVariable Long id, @RequestBody UpdateVacanciesDTO updateVacanciesDTO) {
        Vacancies vacancies = updateVacanciesDTO.updateVacancies(id, vacanciesRepository);

        return ResponseEntity.ok(vacancies);
    }

    @GetMapping("/similar/{id}")
    public ResponseEntity<Set<Vacancies>>  listOfSimilarVacancies(@PathVariable Long id){
        Optional<Vacancies> vacancies = vacanciesRepository.findById(id);
        if(vacancies.isPresent()){
            Set<Vacancies> finalVacancies = new HashSet<Vacancies>();
            for (Technologies technologies:vacancies.get().getTechnologiesRequired()) {
                List<Vacancies> vacanciesByTechologies = vacanciesRepository.findByTechnologiesRequired(technologies);
                finalVacancies.addAll(vacanciesByTechologies);
            }

            return ResponseEntity.ok(finalVacancies);
        }
        System.out.println(vacancies);
        return ResponseEntity.badRequest().build();
    }


}
