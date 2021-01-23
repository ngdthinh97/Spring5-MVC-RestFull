package SrpingMVC.RestFullApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SrpingMVC.RestFullApi.Domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer getCustomerById(Long id);
}
