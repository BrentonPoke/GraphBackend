package graph.backend.Service;

import graph.backend.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import graph.backend.Beans.Food;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public Iterable<Food> listofFood(){
        return foodRepository.findAll();
    }

    public void saveFood(Food save){
        foodRepository.save(save);
    }

    public void deleteFood(Food delete){
        foodRepository.delete(delete);
    }



}
