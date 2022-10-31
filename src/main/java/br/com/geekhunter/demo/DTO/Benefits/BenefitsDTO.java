package br.com.geekhunter.demo.DTO.Benefits;

import br.com.geekhunter.demo.Model.Benefits;

public class BenefitsDTO {

    private String benefits;

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Benefits convert() {
        return new Benefits(this.benefits);
    }
}
