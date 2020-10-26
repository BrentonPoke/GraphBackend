package graph.backend.Service;

import graph.backend.Beans.Animal;
import graph.backend.Beans.QueryObjects.AssignFoodQuery;
import graph.backend.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import graph.backend.Beans.Food;

@Service
public class FoodService {

  private static FoodRepository foodRepository;

  @Autowired
  public FoodService(FoodRepository foodRepository) {
    FoodService.foodRepository = foodRepository;
  }

  public Iterable<Food> listofFood() {
    return foodRepository.findAll();
  }

  public void assignFoodToAnimal(AssignFoodQuery query) {
    foodRepository.assignFoodToAnimal(query.getAnimalName(), query.getFoodName());
  }

  public void assignFoodToManyAnimals(AssignFoodQuery query) {
    //Use streams just to execute multiples 🙃
    query.getAnimals().stream()
        .forEach(
            animal -> {
              foodRepository.assignFoodToAnimal(animal.getAnimalName(), query.getFoodName());
            });
  }

  public void saveFood(Food save) {
    foodRepository.save(save);
  }

  public void deleteFood(Food delete) {
    foodRepository.delete(delete);
  }
}
