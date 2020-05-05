package mission4.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GameStoreModel {
    private String id ;
    private String productName;
    private double productPrice;

}