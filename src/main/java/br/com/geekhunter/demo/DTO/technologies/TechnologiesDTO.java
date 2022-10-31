package br.com.geekhunter.demo.DTO.technologies;

import br.com.geekhunter.demo.Model.Technologies;
import br.com.geekhunter.demo.repository.TechnologiesRepository;

public class TechnologiesDTO {

    private String technologies;
    private String category;

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public Technologies convert() {
        return new Technologies(this.technologies, this.category);
    }

    public Technologies updateTechnologies(Long id, TechnologiesRepository technologiesRepository) {
        Technologies technologies = technologiesRepository.findById(id).get();
        technologies.setCategory(this.category);
        technologies.setTechnologies(this.technologies);
        return technologies;
    }
}
