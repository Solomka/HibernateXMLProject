package employee.DAOSaveTest;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.howtodoinjava.dao.EmployeeDAO;
import com.howtodoinjava.entity.Credentials;
import com.howtodoinjava.entity.EmployeeEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:employee-servlet.xml" })
// @EnableTransactionManagement
public class CustomerRepositoryTest {

	private static final Logger LOGGER = Logger.getLogger(CustomerRepositoryTest.class.getName());

	// @Autowired
	 //@Qualifier("employeeDAO")
	private static EmployeeDAO employeeDAO;

	private EmployeeEntity employeeEntity;

	@BeforeClass
	public static void prepare() {
		// BasicConfigurator.configure(new ConsoleAppender(new SimpleLayout()));
		//final ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:**/employee-servlet.xml");
		 final ApplicationContext ctx = new
		 ClassPathXmlApplicationContext("classpath:employee-servlet.xml");
		employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
	}

	@Before
	public void before() {
		// this.customerPO = generateCustomerPO();
		employeeEntity = generateEmployeeEntity();
	}

	@Test
	// @Transactional
	public void saveEmployeeEntity() {

		employeeDAO.addEmployee(employeeEntity);
		assertNotNull(employeeEntity.getId());
	}

	public static EmployeeEntity generateEmployeeEntity() {

		EmployeeEntity empl = new EmployeeEntity();
		empl.setCredentials(generateCredentials());

		return empl;

	}

	private static Credentials generateCredentials() {

		Credentials credentials = new Credentials();
		credentials.setEmail("bla@gmail.com");
		credentials.setFirstname("Solomka");
		credentials.setLastname("Yaremko");
		credentials.setTelephone("111");

		return credentials;

	}

}
