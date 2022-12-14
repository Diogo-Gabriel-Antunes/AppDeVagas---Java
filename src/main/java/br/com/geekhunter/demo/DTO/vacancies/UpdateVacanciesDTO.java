package br.com.geekhunter.demo.DTO.vacancies;

import br.com.geekhunter.demo.Model.Vacancies;
import br.com.geekhunter.demo.repository.VacanciesRepository;

public class UpdateVacanciesDTO {
    private String jobTitle;
    private String jobDescription;
    private String vacancyLocation;
    private Float salaryRange;
    private Float salaryRangeMax;
    private String seniority;
    private String typeOfContract;
    private String category;
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public Float getSalaryRangeMax() {
        return salaryRangeMax;
    }

    public void setSalaryRangeMax(Float salaryRangeMax) {
        this.salaryRangeMax = salaryRangeMax;
    }

    public Vacancies updateVacancies(Long id, VacanciesRepository repository) {
        Vacancies vacancies = repository.findById(id).get();
        vacancies.setCategory(this.category);
        vacancies.setVacancyLocation(this.vacancyLocation);
        vacancies.setCategory(this.category);
        vacancies.setJobDescription(this.jobDescription);
        vacancies.setSeniority(this.seniority);
        vacancies.setTypeOfContract(this.typeOfContract);
        vacancies.setSalaryRange(this.salaryRange);
        vacancies.setActive(this.active);
        vacancies.setSalaryRangeMax(this.salaryRangeMax);
        return vacancies;
    }


}
