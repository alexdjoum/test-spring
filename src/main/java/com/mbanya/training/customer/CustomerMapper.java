package com.mbanya.training.customer;

import com.mbanya.training.customer.dto.CustomerDto;
import com.mbanya.training.customer.repositories.Gender;
import com.mbanya.training.customer.repositories.Type;
import com.mbanya.training.customer.repositories.model.Customer;

public class CustomerMapper {

    public static Gender mapGender(String gender) {
        if (gender == null) return null;
        switch (gender.toUpperCase()) {
            case "M":
                return Gender.M;
            case "F":
                return Gender.F;
            default:
                return null;
        }
    }

    public static Type mapType(String type) {
        if (type == null) return null;
        switch (type.toUpperCase()) {
            case "VIP":
                return Type.VIP;
            case "SIMPLE":
                return Type.SIMPLE;
            case "BANNED":
                return Type.BANNED;
            default:
                return null;
        }
    }

    public static Customer updateRoomFromDto(Customer customer, CustomerDto request) {
        customer.setGender(mapGender(request.getGender()));
        customer.setType(mapType(request.getType()));
        return customer;
    }

    public static Customer toEntity(CustomerDto request) {
        return Customer.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .gender(mapGender(request.getGender()))
            .birthday(request.getBirthday())
            .type(mapType(request.getType()))
            .description(request.getDescription())
            .countryIdentityNumber(request.getCountryIdentityNumber())
            .countryIdentityType(request.getCountryIdentityType())
            .phoneNumber(request.getPhoneNumber())
            .country(request.getCountry())
            .profession(request.getProfession())
            .city(request.getCity())
            .region(request.getRegion())
            .street(request.getStreet())
            .address(request.getAddress())
            .build();
    }
}
