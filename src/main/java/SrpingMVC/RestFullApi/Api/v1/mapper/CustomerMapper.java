package SrpingMVC.RestFullApi.Api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import SrpingMVC.RestFullApi.Api.v1.model.CustomerDTO;
import SrpingMVC.RestFullApi.Domain.Customer;

@Mapper(uses = {CustomerUrlMapper.class})
public interface CustomerMapper {
	
	CustomerMapper INTANCE = Mappers.getMapper(CustomerMapper.class);
	
	@Mapping(target = "customerUrl", source = "")
	CustomerDTO CustomerToCustomerDTO(Customer customer);
}
