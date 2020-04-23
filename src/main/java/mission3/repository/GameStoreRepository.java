package mission3.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import mission3.model.GameStoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class GameStoreRepository {

        @Autowired
        JdbcTemplate jdbcTemplate;


        abstract class GameStoreRowMapper implements RowMapper<GameStoreModel> {

            @Override
            public GameStoreModel mapRow(ResultSet resultSet, int rowNum) throws SQLException{
                GameStoreModel gameStoreModel = new GameStoreModel();
                gameStoreModel.setId(resultSet.getString("id"));
                gameStoreModel.setProductName(resultSet.getString("product_name"));
                gameStoreModel.setProductPrice(resultSet.getDouble("product_price"));

                return gameStoreModel;
            }
        }

        //GET
        public List<GameStoreModel> getAllgameList(){

            return jdbcTemplate.query("select * from tbl_game_store_profile", new GameStoreRowMapper(){});
        }

        //GET (By Id)
        public Optional<GameStoreModel> getOneProduct(String id){

            return Optional.of(jdbcTemplate.queryForObject("select * from tbl_game_store_profile where id = ?", new Object[]{id
                    },new BeanPropertyRowMapper<GameStoreModel> (GameStoreModel.class)));
        }


        public void removeProduct (String id){

            jdbcTemplate.update("delete from tbl_game_store_profile where id=?", id);
        }


        public void addProduct(GameStoreModel gameStoreModel){
            //Create new data in table with values
            jdbcTemplate.update("insert into tbl_game_store_profile (id,product_name,product_price)"+ "values(?,?,?)",
                    //get value from
                    gameStoreModel.getId(),gameStoreModel.getProductName(), gameStoreModel.getProductPrice());
        }


        public void updateProduct (GameStoreModel gameStoreModel){

            jdbcTemplate.update("update tbl_game_store_profile" + " set product_name = ?, product_price = ?" + "where id = ?",
                    new Object[]{ //get value from
                    gameStoreModel.getProductName(), gameStoreModel.getProductPrice(),gameStoreModel.getId()});

        }
    }
