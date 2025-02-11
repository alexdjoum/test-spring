package com.mbanya.training.customer.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Birthday is required")
    private Date birthday;

    @NotNull(message = "Type is required")
    private String type;

    private String description;

    @NotBlank(message = "Country identity number is required")
    private String countryIdentityNumber;

    @NotBlank(message = "Country identity type is required")
    private String countryIdentityType;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Profession is required")
    private String profession;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Region is required")
    private String region;

    private String street;
    private String address;
}
