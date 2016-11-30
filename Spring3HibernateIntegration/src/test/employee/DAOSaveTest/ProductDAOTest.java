package employee.DAOSaveTest;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.howtodoinjava.dao.ProductDAO;
import com.howtodoinjava.entity.Item;
import com.howtodoinjava.entity.Product;
import com.howtodoinjava.entity.ProductItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/employee-servlet.xml" })
public class ProductDAOTest {

	private static final Logger LOGGER = Logger.getLogger(ProductDAOTest.class.getName());

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void prepare() {
		BasicConfigurator.configure();
		final ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/employee-servlet.xml");
		productDAO = ctx.getBean("productDAO", ProductDAO.class);
	}

	@Before
	public void before() {
		product = generateProduct();
	}

	@Test
	public void saveProduct() {
		productDAO.create(product);
		assertNotNull(product.getId());
	}

	public static Product generateProduct() {
		Product product = new Product();
		product.setName("Bla");
		product.addToProductItem(generateProductItem());
		System.out.println("Product to STORE: " + product );
		return product;
	}
	
	private static ProductItem generateProductItem(){
		ProductItem productItem = new ProductItem();
		productItem.setItem(generateItem());
		return productItem;
	}
	
	private static Item  generateItem(){
		Item item = new Item();
		item.setId(1);	
		return item;
	}

}
