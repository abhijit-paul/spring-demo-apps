package com.example.demoapp.demo.dao;

import java.util.LinkedHashMap;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User   {

    public User()   {

    }

    @Autowired
    @Value("abhijit")
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private String password;

    private String country;

    private static LinkedHashMap<String, String> countryOptions;

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the countryOptions
     */
    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    /**
     * @param countryOptions the countryOptions to set
     */
    @Value("${userdetail.countryoptions}")
    public void setCountryOptions(String[] countries) {
        if(null == User.countryOptions) {
            User.countryOptions = new LinkedHashMap<>();
        }
        for(String country: countries)  {
            User.countryOptions.put(country, country);
        }
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}