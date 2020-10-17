package graph.backend.Service;

import graph.backend.Beans.Animal;
import graph.backend.Beans.QueryObjects.AssignAnimalQuery;
import graph.backend.Beans.QueryObjects.ReassignAnimalQuery;
import graph.backend.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AnimalService {

    private static AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository){
        AnimalService.animalRepository = animalRepository;
    }

    public static Animal byAnimal(String name){
        return animalRepository.findAnimalByAnimalName(name);
    }
    public void assignAnimal(AssignAnimalQuery query){
        animalRepository.assignAnimalToEmployee(query.getAnimalName(),query.getEmpUsername());
    }
    
    public void reassignAnimal(ReassignAnimalQuery query){
        assignAnimal(query);
        animalRepository.removeAnimalFromEmployee(query.getAnimalName(),query.getOldEmpUsername());
    }
    
    public void assignManyAnimals(AssignAnimalQuery query){
        query.getAnimals().stream()
            .forEach(
                animal -> {
                    this.animalRepository.assignAnimalToEmployee(animal.getAnimalName(), query.getEmpUsername());
                });
    }

    public Set<Animal> allAnimals(){
        return animalRepository.findAll();
    }

    public static void saveAnimal (Animal save){
        animalRepository.save(save);
    }

    public static void deleteAnimal(Animal delete){
        animalRepository.delete(delete);
    }

}
