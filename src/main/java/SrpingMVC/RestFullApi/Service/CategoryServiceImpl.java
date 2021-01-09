package SrpingMVC.RestFullApi.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import SrpingMVC.RestFullApi.Api.v1.mapper.CategoryMapper;
import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;
import SrpingMVC.RestFullApi.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	private final CategoryMapper categoryMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDTO)
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
	}

}
