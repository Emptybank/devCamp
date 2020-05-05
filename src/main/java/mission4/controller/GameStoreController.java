package mission4.controller;

import mission4.repository.GameStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mission4.exceptionHandling.gamesNotFoundException;

import mission4.model.GameStoreModel;
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
    public ResponseEntity<Optional <GameStoreModel>> getProductById(@PathVariable("id") String id) {
        Optional<GameStoreModel> res = Optional.ofNullable(gameStoreRepository.getOneProduct(id));
        if (res.isEmpty()) {
            throw new gamesNotFoundException(id);
        } else {
            return ResponseEntity.ok(res);
        }
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

