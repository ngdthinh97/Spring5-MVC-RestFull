package SrpingMVC.RestFullApi.Api.v1.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import SrpingMVC.RestFullApi.Api.v1.model.CustomerDTO;
import SrpingMVC.RestFullApi.Domain.Customer;

@Mapper
public abstract  class CustomerUrlMapper {
	
    @AfterMapping
    protected void setUrl(Customer customer, @MappingTarget CustomerDTO result) {
        result.setCustomerUrl("/shop/customer/"+ customer.getId());
    }
 
    public abstract CustomerDTO customerToCustomerDTO(Customer customer);
}
