import com.demo.Customer;
import com.demo.CustomerRepository;
import com.demo.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testRepository() {
        Customer customer = new Customer();
        customer.setName("Tom");
        customer.setAge(40);

        repository.save(customer);
        assertEquals(1, repository.findAll().size()); // how many records?

        Customer loadedCustomer = repository.findById(customer.getId()).get();
        assertEquals("Tom", loadedCustomer.getName());
        assertEquals(40, loadedCustomer.getAge());

        customer.setName("Peter"); // change the name
        repository.save(customer); // update

        Customer updatedCustomer = repository.findById(customer.getId()).get(); // reload using id
        assertEquals("Peter", updatedCustomer.getName()); // was the update successful?
        assertEquals(40, updatedCustomer.getAge()); // check the age has not changed

        repository.delete(customer); // no customers
        assertEquals(0, repository.findAll().size()); // confirm zero customers

    }
}
