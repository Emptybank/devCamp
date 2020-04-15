package r.demo.Service;

import org.springframework.stereotype.Service;
import r.demo.Model.GameStoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service

public class GameStoreService {


    private List<GameStoreModel> gameList = new ArrayList<>(Arrays.asList(

            new GameStoreModel("00001", "Resident Evil 3 Remake", 60.00),
            new GameStoreModel("00002", "Left 4 Dead 2", 12.30),
            new GameStoreModel("00003", "How to be AD", 10000.00),
             new GameStoreModel("00004","banky",60.00)

    ));

    public List<GameStoreModel> getAllgameList() {
        return gameList;
    }

    public GameStoreModel getOneProduct(String id) {
        return gameList.stream().filter(game -> game.getId().equals(id)).findFirst().get();
    }

    public void addProduct(GameStoreModel gameStoreModel) {
        gameList.add(gameStoreModel);

    }

    public void updateProduct(GameStoreModel gameStoreModel, String id) {
        int counter = 0;
        for (GameStoreModel gameStoreModel1 : gameList) {
            if (gameStoreModel1.getId().equals(id)) {
                gameList.set(counter, gameStoreModel);
            }
            counter++;
        }

    }

    public void removeProduct(String id) {
        gameList.removeIf(gameStoreModel -> gameStoreModel.getId().equals(id));
    }


}
