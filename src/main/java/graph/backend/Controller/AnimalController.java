package graph.backend.Controller;

import graph.backend.Beans.QueryObjects.AssignAnimalQuery;
import graph.backend.Beans.QueryObjects.ReassignAnimalQuery;
import graph.backend.RollBarLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import graph.backend.Beans.Animal;
import graph.backend.Service.AnimalService;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/Animal")
public class AnimalController {
    RollBarLogger rollbar;
    

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService, RollBarLogger rollbar){
        this.rollbar = rollbar;
        this.animalService = animalService;
    }

    @GetMapping
    public Animal byAnimalName(@RequestParam(value="name") String name){
        return AnimalService.byAnimal(name);
    }
    
    @PutMapping("/assignAnimal")
    public @ResponseBody
    ResponseEntity<String> assignAnimal(@RequestBody AssignAnimalQuery query){
        animalService.assignAnimal(query);
        return new ResponseEntity<>(query.toString(), HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/reassignAnimal")
    public @ResponseBody
    ResponseEntity<String> assignAnimal(@RequestBody ReassignAnimalQuery query){
        animalService.reassignAnimal(query);
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
