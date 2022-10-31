package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vacancies")
public class Vacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    @Column(length = 999999999)
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
    @JoinColumn(name = "companyId")
    @JsonBackReference
    private Company companyId;
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

    public Float getSalaryRangeMax() {
        return salaryRangeMax;
    }

    public void setSalaryRangeMax(Float salaryRangeMax) {
        this.salaryRangeMax = salaryRangeMax;
    }

    public Boolean getActive() {
        return active;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
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

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return companyId;
    }

    public void setCompanyId(Company company) {
        this.companyId = company;
    }

    public Set<Technologies> getTechnologiesRequired() {
        return technologiesRequired;
    }

    public void setTechnologiesRequired(Set<Technologies> technologiesRequired) {
        this.technologiesRequired = technologiesRequired;
    }


    public Set<Benefits> getBenefits() {
        return benefits;
    }

    public void setBenefits(Set<Benefits> benefits) {
        this.benefits = benefits;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public Set<Technologies> getTechnologiesDesirable() {
        return technologiesDesirable;
    }

    public void setTechnologiesDesirable(Set<Technologies> technologiesDesirable) {
        this.technologiesDesirable = technologiesDesirable;
    }
}
