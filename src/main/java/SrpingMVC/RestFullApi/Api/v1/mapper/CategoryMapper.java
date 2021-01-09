package SrpingMVC.RestFullApi.Api.v1.mapper;

import org.mapstruct.Mapper; 
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;
import SrpingMVC.RestFullApi.Domain.Category;

@Mapper
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	CategoryDTO categoryToCategoryDTO(Category category);
	
}
