package SrpingMVC.RestFullApi.Api.v1.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;
import SrpingMVC.RestFullApi.Domain.Category;
import SrpingMVC.RestFullApi.Service.CategoryService;

class CategoryMapperTest {
	
    public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    
    CategoryService categoryService;
    
    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
        System.out.println();
    }


}
