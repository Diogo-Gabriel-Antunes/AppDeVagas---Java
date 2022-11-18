package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.Candidate.CandidateDTO;
import br.com.geekhunter.demo.DTO.Candidate.UpdateCandidateDTO;
import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.Service.OportunityService;
import br.com.geekhunter.demo.repository.CandidateRepository;
import br.com.geekhunter.demo.repository.VacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/candidate")
@RestController
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private VacanciesRepository vacanciesRepository;
    @Autowired
    private OportunityService oportunityService;

    @GetMapping
    public List<Candidate> listCandidate() {
        List<Candidate> candidate = candidateRepository.findAll();
        return candidate;
    }

    @GetMapping("/{id}")
    public Candidate detailsCandidate(@PathVariable Long id) {
        Candidate candidate = candidateRepository.findById(id).get();

        return candidate;
    }

    @PostMapping
    public ResponseEntity<Candidate> register(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateDTO.convert();

        candidateRepository.save(candidate);
        URI uri = UriComponentsBuilder.fromPath("/candidate/{id}").buildAndExpand(candidate.getId()).toUri();


        return ResponseEntity.created(uri).body(candidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return ResponseEntity.badRequest().build();
        } else {
            candidateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Candidate> update(@PathVariable Long id, @RequestBody UpdateCandidateDTO candidateDTO) {
        Candidate candidate = candidateDTO.updateCandidate(id, candidateRepository);

        return ResponseEntity.ok(candidate);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Candidate> searchByUser(@PathVariable Long id) {
        try {
            Candidate candidate = candidateRepository.getCandidateByUserId_CandidateId(id);
            if (candidate != null) {
                return ResponseEntity.ok(candidate);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return ResponseEntity.badRequest().build();

    }
    @GetMapping("/opportunity/{id}")
    public Set<Vacancies> listOpportunity(@PathVariable Long id){
        return oportunityService.criaListaDeOportunidades(candidateRepository,vacanciesRepository,id);
    }
}
