package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Vacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    @Column(length = 999999)
    private String jobDescription;

    private String vacancyLocation;

    private Float salaryRange;
    private Float salaryRangeMax;
    private String seniority;
    private String typeOfContract;
    private String category;
    private Boolean active;
    private String activities;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    @ManyToMany
    @JoinTable(name = "Vacancies_Benefits",
            joinColumns = @JoinColumn(name = "Vacancies_FK"),
            inverseJoinColumns = @JoinColumn(name = "Benefits_FK")
    )
    private Set<Benefits> benefits;
    @ManyToMany
    @JoinTable(name = "Vacancies_Technologies",
            joinColumns = @JoinColumn(name = "Vacancies_FK"),
            inverseJoinColumns = @JoinColumn(name = "Technologies_FK")
    )
    private Set<Technologies> technologiesRequired;

    @ManyToMany
    @JoinTable(name = "Vacancies_TechnologiesDesirable",
            joinColumns = @JoinColumn(name = "Vacancies_FK"),
            inverseJoinColumns = @JoinColumn(name = "Technologies_FK")
    )
    private Set<Technologies> technologiesDesirable;

    public Vacancies(String jobTitle, String jobDescription, String vacancyLocation, Float salaryRange, String seniority, String typeOfContract, String category, Boolean active, Float salaryRangeMax) {
        this.jobTitle = jobTitle;

        this.jobDescription = jobDescription;
        this.vacancyLocation = vacancyLocation;
        this.salaryRange = salaryRange;
        this.seniority = seniority;
        this.typeOfContract = typeOfContract;
        this.category = category;
        this.active = active;
        this.salaryRangeMax = salaryRangeMax;
    }

    public Vacancies() {
    }


}
