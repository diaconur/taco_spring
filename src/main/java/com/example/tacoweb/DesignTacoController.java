package com.example.tacoweb;

import java.util.Arrays;
import java.util.List;
import com.example.com.example.data.Ingredient;
import com.example.com.example.data.Ingredient.Type;
import com.example.com.example.data.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){

        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIE),
                new Ingredient("LETC", "Lettuce", Type.VEGGIE)
        );

        Type[] types = Ingredient.Type.values();
        for(Type type:types){
            model.addAttribute(type.toString().toLowerCase());
        }
        model.addAttribute("design", new Taco());

        return "design";

    }
}
