package SrpingMVC.RestFullApi.Repository;

import org.springframework.data.repository.CrudRepository;

import SrpingMVC.RestFullApi.Domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
}
