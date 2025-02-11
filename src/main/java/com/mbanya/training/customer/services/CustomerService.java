package com.mbanya.training.customer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mbanya.training.customer.CustomerMapper;
import com.mbanya.training.customer.dto.CustomerDto;
import com.mbanya.training.customer.repositories.CustomerRepository;
import com.mbanya.training.customer.repositories.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
// @RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveRoom(CustomerDto request) {
        Customer customer = CustomerMapper.toEntity(request);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteACustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateRoom(Long id, CustomerDto request) {
        Optional<Customer> existingCustomerOpt = customerRepository.findById(id);
        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
    
            // Mettre à jour les champs
            existingCustomer.setFirstName(request.getFirstName());
            existingCustomer.setLastName(request.getLastName());
            existingCustomer.setDescription(request.getDescription());
            existingCustomer.setCountryIdentityNumber(request.getCountryIdentityNumber());
            existingCustomer.setCountryIdentityType(request.getCountryIdentityType());
            existingCustomer.setPhoneNumber(request.getPhoneNumber());
            existingCustomer.setCountry(request.getProfession());
            existingCustomer.setCity(request.getCity());
            existingCustomer.setRegion(request.getRegion());
            existingCustomer.setStreet(request.getStreet());
    
            // Utiliser RoomMapper pour convertir Quality et Type
            Customer updatedRoom = CustomerMapper.updateRoomFromDto(existingCustomer, request);
    
            return customerRepository.save(updatedRoom);
        } else {
            throw new RuntimeException("Customer non trouvée avec l'ID : " + id);
        }
    }
}


