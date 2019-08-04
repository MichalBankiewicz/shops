package pl.akademiakodu.shops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*
    robi nam tabele w bazie danych o nazwie shop
 */
@NoArgsConstructor // tworzy pusty konstruktor Shop() jeśli nie istnieje
@AllArgsConstructor // konstruktor 1 z wszystkimi argumentami
@Data // gettery,settery, toString,equals, hashcode
@Entity
public class Shop {

    /*
        tworzy klucz główny, gdzie id
        będą w sposób automatyczny generowane za nas:
        każdy nowy id tworzony jest o 1 większy niż poprzedni
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Integer on ma NULL, 0

    // w bazie danych mamy kolumne name
    private String name;

    // w bazie danych mamy kolumne address
    private String address;

    // to pole nie jest tworzone jako kolumna w bazie danych
    @Transient
    private String description;

    @Override
    public String toString(){
        return name+" "+address;
    }

    @OneToMany(mappedBy = "shop")
    private List<Comment> comments=new ArrayList<>();

}
