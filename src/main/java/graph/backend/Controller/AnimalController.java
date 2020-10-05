package graph.backend.Controller;

import com.rollbar.notifier.Rollbar;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostConstruct
    public void initialize() {
        rollbar = Rollbar.init(withAccessToken("ace12982e3e546f39847979667d97939").environment("production")
                .codeVersion("1.2.1").build());
    }

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping
    public Animal byAnimalName(@RequestParam(value="name") String name){
        Animal animal = AnimalService.byAnimal(name);
        return animal;
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
