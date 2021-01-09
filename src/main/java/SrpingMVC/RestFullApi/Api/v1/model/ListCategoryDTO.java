package SrpingMVC.RestFullApi.Api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListCategoryDTO {
	
	List<CategoryDTO> categories;
}
