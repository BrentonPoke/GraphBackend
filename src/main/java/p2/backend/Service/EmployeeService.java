package p2.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Employee;
import p2.backend.Beans.QueryObjects.AssignAnimalQuery;
import p2.backend.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee byUsername(String username){
        return employeeRepository.findEmployeeByUsername(username);
    }
    public void assignAnimal(AssignAnimalQuery query){
                employeeRepository.assignAnimalToEmployee(query.getAnimalName(),query.getUsername());
    }

    public Employee getByID(Long id){
        return employeeRepository.findEmployeeByEmployeeId(id);
    }

    public void saveEmployee(Employee save){
        employeeRepository.save(save);
    }

    public void deleteEmployee(Employee delete){
        employeeRepository.delete(delete);
    }
}
