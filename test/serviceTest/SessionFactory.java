package serviceTest;

import org.junit.Test;

import com.jyx.s2sh.shop.domain.Category;
import com.jyx.s2sh.shop.service.CategoryService;
import com.jyx.s2sh.shop.service.impl.CategoryServiceImpl;
import com.jyx.s2sh.shop.utils.SpringUtils;

public class SessionFactory extends SpringUtils{
    
    public Category category = new Category();
    public CategoryService categoryservice;
    
    @Test
    public void createTble() {
        context.getBean("categoryService");
    }
    
    @Test
    public void saveCategory() {
        category.setHot(false);
        category.setName("男士休闲");
        category.setId(1);
        CategoryService categoryService = (CategoryService) context.getBean("categoryService");
        categoryService.save(category);
    }
}
