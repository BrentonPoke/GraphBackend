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


@RunWith(SpringRunner.class)
//@WebMvcTest(value=AnimalController.class)
@SpringBootTest(classes = BackendApplication.class)
public class CoordinatesTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Coordinates.class);
    }

    @Test
    public void hashLocationTest() throws Exception {
        HashCodeMethodTester tester = new HashCodeMethodTester();
        tester.testHashCodeMethod(new LocationFactory());

    }

    @Test
    public void equalsLocationTest() throws Exception{
        EqualsMethodTester tester = new EqualsMethodTester();
        tester.testEqualsMethod(new LocationFactory());
    }

}

class LocationFactory implements EquivalentFactory<Coordinates> {

    @Override
    public Coordinates create() {
        Animal mockAnimal = new Animal();
        Coordinates mockCoordinates = new Coordinates(1.234, 5.678,new Location("African Forest",new Coordinates(42.475467, -83.160536)));

        return mockCoordinates;
    }
}