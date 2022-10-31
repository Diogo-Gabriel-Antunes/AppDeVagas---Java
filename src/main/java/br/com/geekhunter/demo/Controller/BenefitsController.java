package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.Benefits.BenefitsDTO;
import br.com.geekhunter.demo.Model.Benefits;
import br.com.geekhunter.demo.repository.BenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/benefits")
public class BenefitsController {

    @Autowired
    private BenefitsRepository benefitsRepository;

    @GetMapping
    public List<Benefits> listBenefits() {
        List<Benefits> benefits = benefitsRepository.findAll();


        return benefits;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Benefits> DetailsBenefits(@PathVariable Long id) {
        Optional<Benefits> benefits = benefitsRepository.findById(id);
        if (benefits.isPresent()) {
            return ResponseEntity.ok(benefits.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Benefits> register(@RequestBody BenefitsDTO benefitsDTO) {
        Benefits benefits = benefitsDTO.convert();

        benefitsRepository.save(benefits);
        URI uri = UriComponentsBuilder.fromPath("/benefits/{id}").buildAndExpand(benefits.getId()).toUri();


        return ResponseEntity.created(uri).body(benefits);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Benefits> benefits = benefitsRepository.findById(id);
        if (benefits.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            benefitsRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Benefits> update(@PathVariable Long id, @RequestBody BenefitsDTO benefitsDTO) {
        Benefits benefits = benefitsRepository.findById(id).get();
        benefits.setBenefits(benefitsDTO.getBenefits());

        return ResponseEntity.ok(benefits);
    }
}
