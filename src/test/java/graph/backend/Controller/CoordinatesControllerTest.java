package graph.backend.Controller;

import graph.backend.Beans.Location;
import graph.backend.Service.CoordinateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import graph.backend.BackendApplication;
import graph.backend.Beans.Animal;
import graph.backend.Beans.Coordinates;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BackendApplication.class)
@SpringBootTest
public class CoordinatesControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private CoordinateService locationService;
    Animal mockAnimal = null;//new Animal("Spencer", "Mathematician turnedprogrammer","likes math", "loves math", 1, 1, "notes");
    Coordinates loc1 = new Coordinates(1.234, 1.234,new Location("Asian Forest",new Coordinates(42.475467, -83.160536)));
    Coordinates loc2 = new Coordinates(5.678, 5.678,new Location("American Grassland",new Coordinates(42.475467, -83.160536)));



    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void locationList() throws Exception {
        List<Coordinates> result = new ArrayList<>();
        result.add(loc1);
        result.add(loc2);
        Mockito.when(locationService.listofCoordinates()).thenReturn(result);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/Location/").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println(response.getResponse());
        String expected = "[{\"latitude\": 1.234,\"longitude\": 1.234,\"animal\": null}," +
                //"{\"animalName\":\"Spencer\",\"scientificName\":\"Mathematician turnedprogrammer\",\"funFact\":\"likes math\",\"summary\":\"loves math\",\"numOfAnimal\":1,\"tracking\":1, \"notes\":\"notes\"}}," +
                "{\"latitude\": 5.678,\"longitude\": 5.678,\"animal\": null }]";
                //"{\"animalName\":\"Spencer\",\"scientificName\":\"Mathematician turnedprogrammer\",\"funFact\":\"likes math\",\"summary\":\"loves math\",\"numOfAnimal\":1,\"tracking\":1, \"notes\":\"notes\"}}]";
        JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);
    }
}