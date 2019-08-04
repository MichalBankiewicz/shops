package pl.akademiakodu.shops.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.akademiakodu.shops.model.Shop;

import java.util.List;

public interface ShopRepository
        extends CrudRepository<Shop,Integer>
{

    @Query(value = "SELECT* FROM shop s WHERE  LOWER (s.name) =  LOWER (:name )", nativeQuery = true)
    List<Shop> findShopByByName(@Param("name") String name);
}
