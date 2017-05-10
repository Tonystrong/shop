package serviceTest;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jyx.s2sh.shop.domain.Account;
import com.jyx.s2sh.shop.domain.Category;
import com.jyx.s2sh.shop.domain.Product;
import com.jyx.s2sh.shop.service.AccountService;
import com.jyx.s2sh.shop.service.CategoryService;
import com.jyx.s2sh.shop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class JunitSpringTestService {
	
	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Test
	public void save() {
		accountService.save(new Account(2, "ted", "strong", "333"));
	}
	
	@Test
	public void update() {
		accountService.update(new Account(2, "tony", "strong", "222"));
	}
	
	@Test
	public void find() {
		System.out.println(accountService.getById(1));
	}
	
	@Test
	public void findAll() {
		List<Product> list = productService.queryProductByCid(1);
		for(Product cate : list) {
			System.out.println(cate);
		}
//		List<Category> list = categoryService.queryByHot(true);
//		for(Category cate : list) {
//			System.out.println(cate);
//		}
	}
	
	@Test
	public void delete() {
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(path);
	}
}
