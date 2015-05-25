package jtechlog.lazy;

import jtechlog.lazy.service.Employee;
import jtechlog.lazy.service.EmployeeService;
import jtechlog.lazy.service.Phone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class EmployeeServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceTest.class);
    
    @Autowired
    DataSource dataSource;
    
    @Autowired
    EmployeeService employeeService;
    
    @Before
    public void testdata() throws SQLException {
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("testdata.sql"));
    }
    
    @Test
    public void testListEmployees() {
        LOGGER.debug("testListEmployees");
        List<Employee> employees = employeeService.listEmployees();
        assertThat(employees.size(), equalTo(2));
        for (Employee employee: employees) {
            for (Phone phone: employee.getPhones()) {
                assertThat(phone.getNumber(), notNullValue());
            }
        }
    }

    @Test
    public void testFindEmployeeById() {
        LOGGER.debug("testFindEmployeeById");
        Employee employee = employeeService.findEmployeeById(1);
        assertThat(employee.getName(), equalTo("John Doe"));
    }

    @Test
    public void testMerge() {
        LOGGER.debug("testMerge");
        Employee employee = employeeService.findEmployeeById(1);
        employee.setName("John Doe 2");
        employeeService.mergeEmployee(employee);

        employeeService.findEmployeeById(1);
        assertThat(employee.getName(), equalTo("John Doe 2"));
    }
}
