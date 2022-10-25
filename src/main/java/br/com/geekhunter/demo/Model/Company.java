package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Company {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String CNPJ;
    private Integer numberEmployees;
    private String adress;
    private String corporateEmail;
    private String managerRH;

    private String companyDescription;
    @OneToMany(mappedBy = "companyId")
    @JsonManagedReference
    private List<Vacancies> vacancies;

    public Company() {
    }

    public Company(String companyName, String CNPJ, Integer numberEmployees, String adress, String corporateEmail, String managerRH, String companyDescription) {
        this.companyName = companyName;
        this.CNPJ = CNPJ;
        this.numberEmployees = numberEmployees;
        this.adress = adress;
        this.corporateEmail = corporateEmail;
        this.managerRH = managerRH;
        this.companyDescription = companyDescription;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Vacancies> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancies> vacancies) {
        this.vacancies = vacancies;
    }
}
