package SrpingMVC.RestFullApi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import SrpingMVC.RestFullApi.Api.v1.model.CustomerDTO;
import SrpingMVC.RestFullApi.Api.v1.model.ListCategoryDTO;
import SrpingMVC.RestFullApi.Api.v1.model.ListCustomerDTO;
import SrpingMVC.RestFullApi.Service.CustomerService;

@Controller
@RequestMapping("/api/v1/customer")
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<ListCustomerDTO> getAllCustomer() {

		return new ResponseEntity<ListCustomerDTO>(new ListCustomerDTO(customerService.getListCustomer()),
				HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id){
		
		return new ResponseEntity<CustomerDTO>(customerService.findById(Long.valueOf(id)),
				HttpStatus.OK);
	}
}
