package SrpingMVC.RestFullApi.Service;

import java.util.List;

import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;

public interface CategoryService{

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
