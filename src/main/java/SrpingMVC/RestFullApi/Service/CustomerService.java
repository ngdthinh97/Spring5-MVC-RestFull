package SrpingMVC.RestFullApi.Service;

import java.util.List; 

import SrpingMVC.RestFullApi.Api.v1.model.CustomerDTO;
import SrpingMVC.RestFullApi.Domain.Customer;

public interface CustomerService {

	public List<CustomerDTO> getListCustomer();
	
	public CustomerDTO findById(Long id);
}
