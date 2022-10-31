package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.Candidate.CandidateDTO;
import br.com.geekhunter.demo.DTO.Candidate.UpdateCandidateDTO;
import br.com.geekhunter.demo.Model.Candidate;
import br.com.geekhunter.demo.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

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
        if (candidate.isEmpty()) {
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
    Optional<Candidate> candidate = candidateRepository.findByuserId(id);
    if(candidate.isPresent()){
        return ResponseEntity.ok(candidate.get());
    }
    return ResponseEntity.badRequest().build();
    }
}
