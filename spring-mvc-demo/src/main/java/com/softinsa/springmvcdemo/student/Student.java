package com.softinsa.springmvcdemo.student;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private String favoriteProgrammingLanguage;

    private ArrayList<String> operatingSystems = new ArrayList<>();

    private final LinkedHashMap<String, String> countryOptions = new LinkedHashMap<>();

    private final ArrayList<String> operatingSystemsOptions = new ArrayList<>();

    private final ArrayList<String> programmingLanguageOptions = new ArrayList<>();

    public Student() {
        this.initStudent();
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.initStudent();
    }

    private void initStudent() {
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        programmingLanguageOptions.add("Java");
        programmingLanguageOptions.add("C#");
        programmingLanguageOptions.add("PHP");
        programmingLanguageOptions.add("Ruby");
        operatingSystemsOptions.add("Linux");
        operatingSystemsOptions.add("Mac OS");
        operatingSystemsOptions.add("Ms Windows");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return countryOptions.get(country);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteProgrammingLanguage() {
        return favoriteProgrammingLanguage;
    }

    public void setFavoriteProgrammingLanguage(String favoriteProgrammingLanguage) {
        this.favoriteProgrammingLanguage = favoriteProgrammingLanguage;
    }

    public ArrayList<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(ArrayList<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public ArrayList<String> getProgrammingLanguageOptions() {
        return programmingLanguageOptions;
    }

    public ArrayList<String> getOperatingSystemsOptions() {
        return operatingSystemsOptions;
    }
}
