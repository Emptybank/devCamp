package mission3.controller;

import mission3.repository.GameStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mission3.model.GameStoreModel;
import java.util.List;
import java.util.Optional;

@RestController

public class GameStoreController {

    @Autowired
    private GameStoreRepository gameStoreRepository;

    @GetMapping("/api/games")
    public List<GameStoreModel> allProducts() {
        return gameStoreRepository.getAllgameList();
    }

    @GetMapping("/api/game/{id}")
    public Optional <GameStoreModel> getProductById(@PathVariable("id") String id) {
        return gameStoreRepository.getOneProduct(id);
    }

    @PostMapping("/api/game")
    public void addProduct(@RequestBody GameStoreModel gameStoreModel) {
        gameStoreRepository.addProduct(gameStoreModel);
    }

    @PutMapping("/api/game/{id}")
    public void updateProduct(@RequestBody GameStoreModel gameStoreModel, @PathVariable("id") String id) {
        gameStoreRepository.updateProduct(gameStoreModel);
    }

    @DeleteMapping("/api/game/{id}")
    public void removeProduct(@PathVariable("id") String id) {
        gameStoreRepository.removeProduct(id);


    }
}

