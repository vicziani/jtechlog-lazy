package jtechlog.lazy.web;

import jtechlog.lazy.service.Employee;
import jtechlog.lazy.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/editEmployee.html")
@SessionAttributes("employee")
public class EditEmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editEmployee(@RequestParam long id) {
        return new ModelAndView("editEmployee", "employee", employeeService.findEmployeeById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String editEmployeePost(@ModelAttribute("employee") Employee employee,
                                   SessionStatus status) {
        employeeService.mergeEmployee(employee);
        status.setComplete();
        return "redirect:/employees.html";
    }
}
