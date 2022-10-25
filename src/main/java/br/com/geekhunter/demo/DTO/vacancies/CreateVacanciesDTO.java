package br.com.geekhunter.demo.DTO.vacancies;

import br.com.geekhunter.demo.Model.Company;
import br.com.geekhunter.demo.Model.Vacancies;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreateVacanciesDTO {

    private String jobTitle;
    private String jobDescription;
    private String vacancyLocation;
    private Float salaryRange;
    private Float salaryRangeMax;
    private String seniority;
    private String typeOfContract;
    private String category;

    public Float getSalaryRangeMax() {
        return salaryRangeMax;
    }

    public void setSalaryRangeMax(Float salaryRangeMax) {
        this.salaryRangeMax = salaryRangeMax;
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

    public Vacancies convert() {
        return new Vacancies(this.jobTitle, this.jobDescription, this.vacancyLocation, this.salaryRange, this.seniority, this.typeOfContract, this.category,true,this.salaryRangeMax );
    }
}
