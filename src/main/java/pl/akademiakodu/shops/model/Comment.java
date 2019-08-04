package pl.akademiakodu.shops.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    // boolean ->false, true
    private boolean cheap;

    private Double price;
    /*
        OneToOne sprawia, że będzie tworzony
        klucz obcy o nazwie shop_id, który będzie odnosił
        się do tabeli shop
     */
    @OneToOne
    private Shop shop;
    /*
        Co to na nam daje adnotacja OneToOne:
        1) private int shop_id;
        2) W sposób automagiczny będzie nam działać metoda
        getShop(), która będzie zwraca sklep do które przypisany jest komentarz
     */
    @Override
    public String toString(){
        return getDescription();
    }
}
