package graph.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Food;
import graph.backend.Service.FoodService;

@CrossOrigin
@RestController
@RequestMapping("/Food")
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }
    @RequestMapping("/")
    public Iterable<Food> EventList(){
        return foodService.listofFood();
    }

    @PostMapping("/save")
    public void saveEvent(@RequestBody Food save){
        foodService.saveFood(save);
    }

    @PostMapping("/delete")
    public void deleteEvent(@RequestBody Food delete){
        foodService.deleteFood(delete);
    }
}
