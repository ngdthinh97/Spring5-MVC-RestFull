package SrpingMVC.RestFullApi.Bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import SrpingMVC.RestFullApi.Domain.Category;
import SrpingMVC.RestFullApi.Domain.Customer;
import SrpingMVC.RestFullApi.Repository.CategoryRepository;
import SrpingMVC.RestFullApi.Repository.CustomerRepository;

@Component
public class Bootraps implements CommandLineRunner {

	CategoryRepository categoryRepository;

	CustomerRepository customerRepository;

	public Bootraps(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCustomer();
		loadCategory();
	}

	public void loadCustomer() {

		List<Customer> lstCustomer = new ArrayList();

		Customer thinhCus = new Customer();
		thinhCus.setName("Thinh");

		Customer ThaiCus = new Customer();
		ThaiCus.setName("Thai");

		Customer danhCus = new Customer();
		danhCus.setName("Danh");

		lstCustomer.add(thinhCus);
		lstCustomer.add(ThaiCus);
		lstCustomer.add(danhCus);
		
		customerRepository.save(thinhCus);
		customerRepository.save(ThaiCus);
		customerRepository.save(danhCus);
		
	}

	public void loadCategory() {
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
