package SrpingMVC.RestFullApi.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import SrpingMVC.RestFullApi.Api.v1.mapper.CustomerMapper;
import SrpingMVC.RestFullApi.Api.v1.model.CustomerDTO;
import SrpingMVC.RestFullApi.Domain.Customer;
import SrpingMVC.RestFullApi.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;

	CustomerMapper customerMapper;

	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		super();
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	@Override
	public List<CustomerDTO> getListCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll().stream().
				map(cus -> {
					CustomerDTO customerDTO = customerMapper.CustomerToCustomerDTO(cus);
					customerDTO.setCustomerUrl("/api/v1/customer" + String.valueOf(customerDTO.getId()));
					return customerDTO;
				})
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(Long id) {
		// TODO Auto-generated method stub
		
//		CustomerDTO customer = customerMapper.CustomerToCustomerDTO(customerRepository.getCustomerById(id));
//		customer.setCustomerUrl("/api/v1/customer" + String.valueOf(customer.getId()));
//		
//		return customer;
        return customerRepository.findById(id) // by this code will not return URL for customer
                .map(customerMapper::CustomerToCustomerDTO)
                .orElseThrow(RuntimeException::new); 
	}

}
