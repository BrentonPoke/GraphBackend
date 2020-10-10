package graph.backend.Controller;

import com.rollbar.notifier.Rollbar;
import graph.backend.Beans.QueryObjects.AssignAnimalQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Animal;
import graph.backend.Service.AnimalService;

import javax.annotation.PostConstruct;
import java.util.Set;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

@CrossOrigin
@RestController
@RequestMapping("/Animal")
public class AnimalController {
    Rollbar rollbar;
    

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService, Rollbar rollbar){
        this.rollbar = rollbar;
        this.animalService = animalService;
    }

    @GetMapping
    public Animal byAnimalName(@RequestParam(value="name") String name){
        Animal animal = AnimalService.byAnimal(name);
        return animal;
    }
    
    @PutMapping("/assignAnimal")
    public @ResponseBody
    ResponseEntity<String> assignAnimal(@RequestBody AssignAnimalQuery query){
        animalService.assignAnimal(query);
        return new ResponseEntity<>(query.toString(), HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/assignAnimals")
    public @ResponseBody ResponseEntity<String> assignAnimals(@RequestBody AssignAnimalQuery query){
        animalService.assignManyAnimals(query);
        return new ResponseEntity<>(query.toString(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    Set<Animal> getAnimals(){
        return animalService.allAnimals();
    }

    @PostMapping("/save")
    public void saveAnimal(@RequestBody Animal save ){
        animalService.saveAnimal(save);
    }

    @PostMapping("/delete")
    public void deleteAnimal(@RequestBody Animal delete ){
        animalService.deleteAnimal(delete);
    }
}
