package graph.backend.Service;

import graph.backend.Beans.Animal;
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