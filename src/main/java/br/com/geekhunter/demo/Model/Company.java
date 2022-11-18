package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;



@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String CNPJ;
    private Integer numberEmployees;
    private String adress;
    private String corporateEmail;
    private String managerRH;

    private String companyDescription;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Vacancies> vacancies;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User userId;


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
}
