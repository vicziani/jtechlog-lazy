package jtechlog.lazy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Subgraph;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /*EntityGraph<Employee> graph = em.createEntityGraph(Employee.class);
        graph.addAttributeNodes("name");
        Subgraph<Phone> subgraph = graph.addSubgraph("phones", Phone.class);
        subgraph.addAttributeNodes("type");
        List<Employee> employees = em.createNamedQuery("listEmployees", Employee.class)
                .setHint("javax.persistence.fetchgraph", graph)
                .getResultList();*/

        return employees;
    }

    @Override
    public Employee findEmployeeById(long id) {
        return em.find(Employee.class, id);
        //return em.createNamedQuery("findEmployeeById", Employee.class).setParameter("id", id).getSingleResult();

//        Map hints = new HashMap();
//        hints.put("javax.persistence.fetchgraph", em.getEntityGraph("graph.Employee.phones"));
//        return em.find(Employee.class, id, hints);
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
