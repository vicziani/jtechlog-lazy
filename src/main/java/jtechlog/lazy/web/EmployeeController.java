package jtechlog.lazy.web;

import jtechlog.lazy.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index.html")
    public String index() {
        return "redirect:/employees.html";
    }

    @RequestMapping("/employees.html")
    public ModelAndView listEmployees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        LOGGER.debug("Call service listEmployees");
        modelAndView.addObject("employees", employeeService.listEmployees());
        LOGGER.debug("Redirect to view employees.jsp");
        return modelAndView;
    }

    @RequestMapping("/employee.html")
    public ModelAndView findEmployeeById(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("employee");
        LOGGER.debug("Call service findEmployeeById");
        modelAndView.addObject("employee", employeeService.findEmployeeById(id));
        LOGGER.debug("Redirect to view employee.jsp");
        return modelAndView;
    }

}
