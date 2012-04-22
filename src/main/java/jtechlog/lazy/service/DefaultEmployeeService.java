package jtechlog.lazy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUtil;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultEmployeeService implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultEmployeeService.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        List<Employee> employees = em.createNamedQuery("listEmployees", Employee.class).getResultList();
        /*for (Employee e: employees) {
            e.getPhones().size();
            if (e.getPhones().size() > 0) {
                LOGGER.debug(e.getPhones().get(0).getNumber());
            }
        }*/
        return employees;
    }

    @Override
    public Employee findEmployeeById(long id) {
        return em.find(Employee.class, id);
        // return em.createNamedQuery("findEmployeeById", Employee.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void mergeEmployee(Employee employee) {
        LOGGER.debug("Phones: " + Persistence.getPersistenceUtil().isLoaded(employee.getPhones()));
        // employee.addPhone(new Phone("home", "123"));
        // employee.setPhones(Collections.singletonList(new Phone("home", "123")));
        em.merge(employee);
    }
}
