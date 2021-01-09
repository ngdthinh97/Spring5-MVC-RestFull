package SrpingMVC.RestFullApi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;
import SrpingMVC.RestFullApi.Api.v1.model.ListCategoryDTO;
import SrpingMVC.RestFullApi.Service.CategoryService;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryController {

	CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<ListCategoryDTO> getaAllCategoryDTO(){
		
		return new ResponseEntity<ListCategoryDTO>(
				new ListCategoryDTO(categoryService.getAllCategories()),HttpStatus.OK);
	}
	
	@GetMapping("{name}")
	public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){
		
		return new ResponseEntity<CategoryDTO>(categoryService.getCategoryByName(name),HttpStatus.OK);
	}
}
