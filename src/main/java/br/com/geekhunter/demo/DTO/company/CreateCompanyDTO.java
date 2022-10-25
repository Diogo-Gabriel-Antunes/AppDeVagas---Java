package br.com.geekhunter.demo.DTO.company;


import br.com.geekhunter.demo.Model.Company;

public class CreateCompanyDTO {
    private String companyName;
    private String CNPJ;
    private Integer numberEmployees;
    private String adress;
    private String corporateEmail;
    private String managerRH;
    private String companyDescription;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public String getManagerRH() {
        return managerRH;
    }

    public void setManagerRH(String managerRH) {
        this.managerRH = managerRH;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public Company convert() {
        return new Company(this.companyName,
                this.CNPJ,
                this.numberEmployees,
                this.adress,
                this.corporateEmail,
                this.managerRH,
                this.companyDescription);
    }
}
