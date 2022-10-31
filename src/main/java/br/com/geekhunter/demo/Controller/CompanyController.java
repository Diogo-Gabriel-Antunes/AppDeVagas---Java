package br.com.geekhunter.demo.Controller;


import br.com.geekhunter.demo.DTO.company.CreateCompanyDTO;
import br.com.geekhunter.demo.DTO.company.UpdateCompanyDTO;
import br.com.geekhunter.demo.Model.Company;
import br.com.geekhunter.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/companies")
@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> listCompany() {
        List<Company> company = companyRepository.findAll();


        return company;
    }

    @GetMapping("/{id}")
    public Company DetailsCompany(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);

        return company.get();
    }

    @PostMapping
    public ResponseEntity<Company> register(@RequestBody CreateCompanyDTO createCompanyDTO) {
        Company company = createCompanyDTO.convert();

        companyRepository.save(company);
        URI uri = UriComponentsBuilder.fromPath("/company/{id}").buildAndExpand(company.getId()).toUri();


        return ResponseEntity.created(uri).body(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            companyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody UpdateCompanyDTO updateCompany) {
        Company company = updateCompany.convert(id, companyRepository);

        return ResponseEntity.ok(company);
    }

}


