package graph.backend.Controller;


import graph.backend.Beans.QueryObjects.AssignFoodQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @PutMapping("/assignFood")
    public @ResponseBody ResponseEntity<String> assignFood(AssignFoodQuery query){
        this.foodService.assignFoodToAnimal(query);
        return new ResponseEntity<>(query.toString(), HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/assignFoods")
    public @ResponseBody ResponseEntity<String> assignFoods(AssignFoodQuery query){
        this.foodService.assignFoodToManyAnimals(query);
        return new ResponseEntity<>(query.toString(), HttpStatus.ACCEPTED);
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
