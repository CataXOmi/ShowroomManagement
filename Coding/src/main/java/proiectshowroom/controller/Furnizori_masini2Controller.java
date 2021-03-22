package proiectshowroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proiectshowroom.dao.Furnizori_masini2DAO;
import proiectshowroom.model.Furnizori_masini2;

import java.util.List;

@Controller
public class Furnizori_masini2Controller {

    @Autowired
    private Furnizori_masini2DAO dao;

    @RequestMapping("/vizualizare2")
    public String viewHomePage(Model model) {
        List<Furnizori_masini2> listaFurnizorimasini2 = dao.show();
        model.addAttribute("listaFurnizorimasini2", listaFurnizorimasini2);
        return "furnizori_masini2/show";
    }
}
