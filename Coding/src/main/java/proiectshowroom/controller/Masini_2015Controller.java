package proiectshowroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proiectshowroom.dao.Masini_2015DAO;
import proiectshowroom.model.Masini_2015;

import java.util.List;

@Controller
public class Masini_2015Controller {
    @Autowired
    private Masini_2015DAO dao;

    @RequestMapping("/vizualizare1")
    public String viewHomePage(Model model) {
        List<Masini_2015> listaMasini2015 = dao.show();
        model.addAttribute("listaMasini2015", listaMasini2015);
        return "masini_2015/show";
    }
}
