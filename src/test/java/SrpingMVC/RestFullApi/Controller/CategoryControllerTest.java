package SrpingMVC.RestFullApi.Controller;

import static org.hamcrest.CoreMatchers.equalTo; 
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.anyString;
import SrpingMVC.RestFullApi.Api.v1.mapper.CategoryMapper;
import SrpingMVC.RestFullApi.Api.v1.model.CategoryDTO;
import SrpingMVC.RestFullApi.Domain.Category;
import SrpingMVC.RestFullApi.Service.CategoryService;

class CategoryControllerTest {
	
	public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    
    @Mock
    CategoryService categoryService;
    
    @InjectMocks
    CategoryController categoryController;
    
    MockMvc mockMvc; 
    
    @BeforeEach
    private void setup() {
    	MockitoAnnotations.openMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    	System.out.println();
    }
    
    @Test
    public void getCategoryByName() throws Exception{
       
    	//given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);
        
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        
        when(categoryService.getCategoryByName(anyString())).thenReturn(categoryDTO);
     
        mockMvc.perform(get("/api/v1/categories/Joe")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.id", equalTo(1)))
        		.andExpect(jsonPath("$.name", equalTo(NAME)));
        
    }
    
    @Test
    public void testListCategories() throws Exception {
        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1l);
        category1.setName(NAME);

        CategoryDTO category2 = new CategoryDTO();
        category2.setId(2l);
        category2.setName("Bob");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);

        when(categoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/v1/categories/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.categories", hasSize(2)));
        
        System.out.println();
    }

}
