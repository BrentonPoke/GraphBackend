package p2.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import p2.backend.Beans.Animal;
import p2.backend.Beans.Employee;
import p2.backend.Repository.AnimalRepository;

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
