package pl.akademiakodu.shops.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.shops.model.Comment;
import pl.akademiakodu.shops.model.Shop;
import pl.akademiakodu.shops.repository.ShopRepository;

@Controller
public class ShopController {
    /*
        ShopRepository to interfejs z 11 metodami min save, findAll
        Fabryka springa szuka beana, która implementuje interfejs ShopRepository.
        Czy go znajduje? NIE
        Zgadza się? TAK
        Bierze generacje beana na siebie, generuje klasę z implemtacjami tych
        metod "automagicznie"
     */

    @Autowired
    private ShopRepository shopRepository;

    // ShopRepostiory.findAll()

    @GetMapping("/")
    public String home(ModelMap map) {
        map.put("shops", shopRepository.findAll());
        map.put("shop", new Shop());
        return "home";
    }

    @PostMapping("/shops")
    public String create(@ModelAttribute Shop shop) {
        shopRepository.save(shop);
        return "redirect:/";
    }

    // shops/2
    @GetMapping("/shops/{id}")
    public String show(@PathVariable Integer id, ModelMap map) {
        Shop shop = shopRepository.findById(id).get();
        map.put("shop", shop);
        Comment comment = new Comment();
        comment.setShop(shop);
        map.put("comment", comment);
        return "show";
    }
    @GetMapping("/search")
    public String search(@RequestParam String name, ModelMap map){
       map.addAttribute("shops",shopRepository.findShopByByName(name).toString());
 /*       map.addAttribute("message","Znalezione sklepy:");
        map.put("shop", new Shop());*/
        if (shopRepository.findShopByByName(name).size()>0)
            map.addAttribute("message","Znalezione sklepy:");
        else
            map.addAttribute("message","Nie znaleziono sklepu");
            map.put("shop",new Shop());
        return "home";
    }
}
