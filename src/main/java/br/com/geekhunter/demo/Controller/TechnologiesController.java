package br.com.geekhunter.demo.Controller;


import br.com.geekhunter.demo.DTO.technologies.TechnologiesDTO;
import br.com.geekhunter.demo.Model.Technologies;
import br.com.geekhunter.demo.repository.TechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/technologies")
@RestController
public class TechnologiesController {

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @GetMapping
    public List<Technologies> listVacancies() {
        List<Technologies> technologies = technologiesRepository.findAll();
        return technologies;
    }

    @GetMapping("/{id}")
    public Technologies detailsVacancies(@PathVariable Long id) {
        Technologies technologies = technologiesRepository.findById(id).get();

        return technologies;
    }

    @PostMapping
    public ResponseEntity<Technologies> register(@RequestBody TechnologiesDTO technologiesDTO) {
        Technologies technologies = technologiesDTO.convert();

        technologiesRepository.save(technologies);
        URI uri = UriComponentsBuilder.fromPath("/technologies/{id}").buildAndExpand(technologies.getId()).toUri();


        return ResponseEntity.created(uri).body(technologies);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Technologies> technologies = technologiesRepository.findById(id);
        if (technologies.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            technologiesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Technologies> update(@PathVariable Long id, @RequestBody TechnologiesDTO technologiesDTO) {
        Technologies technologies = technologiesDTO.updateTechnologies(id, technologiesRepository);

        return ResponseEntity.ok(technologies);
    }

}
