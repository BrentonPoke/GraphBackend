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
public class EventsTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Events.class);
    }

    @Test
    public void hashLocationTest() throws Exception {
        HashCodeMethodTester tester = new HashCodeMethodTester();
        tester.testHashCodeMethod(new EventsFactory());

    }

    @Test
    public void equalsLocationTest() throws Exception{
        EqualsMethodTester tester = new EqualsMethodTester();
        tester.testEqualsMethod(new EventsFactory());
    }

}

class EventsFactory implements EquivalentFactory<Events> {

    @Override
    public Events create() {
        Events mockEvent = new Events("what", "where", "when");

        return mockEvent;
    }

}