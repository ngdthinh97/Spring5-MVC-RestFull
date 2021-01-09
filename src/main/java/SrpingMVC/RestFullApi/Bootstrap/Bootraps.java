package SrpingMVC.RestFullApi.Bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import SrpingMVC.RestFullApi.Domain.Category;
import SrpingMVC.RestFullApi.Repository.CategoryRepository;

@Component
public class Bootraps implements CommandLineRunner{

	CategoryRepository categoryRepository;
	
	public Bootraps(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Category> lstCateFruit = new ArrayList<Category>();
		
		Category orange = new Category();
		orange.setName("Orange");
		Category lemond = new Category();
		lemond.setName("Lemond");
		Category strawberry = new Category();
		strawberry.setName("Strawberry");
		Category mango = new Category();
		mango.setName("Mango");
		
		lstCateFruit.add(orange);
		lstCateFruit.add(lemond);
		lstCateFruit.add(strawberry);
		lstCateFruit.add(mango);
		
		categoryRepository.save(orange);
		categoryRepository.save(lemond);
		categoryRepository.save(strawberry);
		categoryRepository.save(mango);
		
	}

	
}
