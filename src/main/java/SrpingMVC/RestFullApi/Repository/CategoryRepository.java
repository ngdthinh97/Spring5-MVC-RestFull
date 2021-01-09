package SrpingMVC.RestFullApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import SrpingMVC.RestFullApi.Domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category findByName(String name);
}
