package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vacancies")
public class Vacancies{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    private String jobDescription;

    private String vacancyLocation;

    private Float salaryRange;
    private String seniority;
    private String typeOfContract;
    private String category;
    private boolean active;
    private String activities;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Company company;
    @ManyToMany
    private List<Technologies> technologies;


    public Vacancies(String jobTitle, String jobDescription, String vacancyLocation, Float salaryRange, String seniority, String typeOfContract, String category) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.vacancyLocation = vacancyLocation;
        this.salaryRange = salaryRange;
        this.seniority = seniority;
        this.typeOfContract = typeOfContract;
        this.category = category;

    }

    public Vacancies() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getVacancyLocation() {
        return vacancyLocation;
    }

    public void setVacancyLocation(String vacancyLocation) {
        this.vacancyLocation = vacancyLocation;
    }

    public Float getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(Float salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Technologies> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technologies> technologies) {
        this.technologies = technologies;
    }
}