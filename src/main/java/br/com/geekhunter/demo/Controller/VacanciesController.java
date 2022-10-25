package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.company.CreateCompanyDTO;
import br.com.geekhunter.demo.DTO.company.UpdateCompanyDTO;
import br.com.geekhunter.demo.DTO.vacancies.CreateVacanciesDTO;
import br.com.geekhunter.demo.DTO.vacancies.UpdateVacanciesDTO;
import br.com.geekhunter.demo.Model.Company;
import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.repository.CompanyRepository;
import br.com.geekhunter.demo.repository.VacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/vacancies")
@RestController
public class VacanciesController {

    @Autowired
    private VacanciesRepository vacanciesRepository;

    @GetMapping
    public List<Vacancies> listVacancies(){
        List<Vacancies> vacancies =  vacanciesRepository.findAll();
        return vacancies;
    }

    @GetMapping("/{id}")
    public Vacancies detailsVacancies(@PathVariable Long id){
        Vacancies vacancies =  vacanciesRepository.findById(id).get();

        return vacancies;
    }
    @PostMapping
    public ResponseEntity<Vacancies> register(@RequestBody CreateVacanciesDTO createVacanciesDTO){
        Vacancies vacancies =  createVacanciesDTO.convert();

        vacanciesRepository.save(vacancies);
        URI uri = UriComponentsBuilder.fromPath("/company/{id}").buildAndExpand(vacancies.getId()).toUri();


        return ResponseEntity.created(uri).body(vacancies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Vacancies> vacancies = vacanciesRepository.findById(id);
        if(vacancies.isEmpty()){
            return ResponseEntity.badRequest().build();
        }else{
            vacanciesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Vacancies> update(@PathVariable Long id,@RequestBody UpdateVacanciesDTO updateVacanciesDTO){
        Vacancies vacancies = updateVacanciesDTO.updateVacancies(id, vacanciesRepository);

        return ResponseEntity.ok(vacancies);
    }

}
