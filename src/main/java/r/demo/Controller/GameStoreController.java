package r.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import r.demo.Model.GameStoreModel;
import r.demo.Service.GameStoreService;

import java.util.List;

@RestController

public class GameStoreController {

    @Autowired
    private GameStoreService gameStoreService;

    @GetMapping("/api/product")
    public List<GameStoreModel> allProducts() {
        return gameStoreService.getAllgameList();
    }

    @GetMapping("/api/product/{id}")
    public GameStoreModel getProductById(@PathVariable("id") String id) {
        return gameStoreService.getOneProduct(id);
    }

    @PostMapping("/api/product")
    public void addProduct(@RequestBody GameStoreModel gameStoreModel) {
        gameStoreService.addProduct(gameStoreModel);
    }

    @PutMapping("/api/product/{id}")
    public void updateProduct(@RequestBody GameStoreModel gameStoreModel, @PathVariable("id") String id) {
        gameStoreService.updateProduct(gameStoreModel, id);
    }

    @DeleteMapping("/api/product/{id}")
    public void removeProduct(@PathVariable("id") String id) {
        gameStoreService.removeProduct(id);


    }
}

