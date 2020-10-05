package graph.backend.Beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import graph.backend.BackendApplication;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
//@WebMvcTest(value=AnimalController.class)
@SpringBootTest(classes = BackendApplication.class)
public class AnimalTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Animal.class);
    }

    @Test
    public void hashAnimalTest() throws Exception {
        HashCodeMethodTester tester = new HashCodeMethodTester();
        tester.testHashCodeMethod(new AnimalFactory());

    }

    @Test
    public void equalsLocationTest() throws Exception{
        EqualsMethodTester tester = new EqualsMethodTester();
        tester.testEqualsMethod(new LocationFactory());
    }

}


class AnimalFactory implements EquivalentFactory<Animal> {

    @Override
    public Animal create() {

        Food food = new Food();
        Set<Food> mockFood = new HashSet<>();
        mockFood.add(food);
        Employee emp = new Employee("First Name Also", "Last Name Also", "Username Also", "Password Also", 1);
        Set<Employee> employees = new HashSet<>();
        employees.add(emp);
        Animal mockAnimal = new Animal("Spencer", "sci name", "fun fact",
                "summary", 1, 1, "notes");

        return mockAnimal;
    }
}