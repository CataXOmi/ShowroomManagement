package proiectshowroom.controller;

import proiectshowroom.dao.FurnizoriDAO;
import proiectshowroom.model.Furnizori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FurnizoriController {

    @Autowired
    private FurnizoriDAO dao;

    @RequestMapping("/furnizori")
    public String viewHomePage(Model model) {
        List<Furnizori> listaFurnizori = dao.list();
        model.addAttribute("listaFurnizori", listaFurnizori);

        return "furnizori/show";
    }

    @RequestMapping("/furnizori/new")
    public String showNewForm(Model model) {
        Furnizori furnizor = new Furnizori();
        model.addAttribute("furnizor", furnizor);

        return "furnizori/new_form";
    }

    @RequestMapping(value = "/furnizori/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Furnizori") Furnizori furnizor) {
        dao.save(furnizor);

        return "redirect:/furnizori";
    }

    @RequestMapping("/furnizori/edit/{id_furnizor}")
    public ModelAndView showEditForm(@PathVariable(name = "id_furnizor") Integer id_furnizor) {
        ModelAndView mav = new ModelAndView("furnizori/edit_form");
        Furnizori furnizor = dao.get(id_furnizor);
        mav.addObject("furnizor", furnizor);

        return mav;
    }

    @RequestMapping(value = "/furnizori/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Furnizori") Furnizori furnizor) {
        dao.update(furnizor);

        return "redirect:/furnizori";
    }

    @RequestMapping("/furnizori/delete/{id_furnizor}")
    public String delete(@PathVariable(name = "id_furnizor") Integer id_furnizor) {
        dao.delete(id_furnizor);

        return "redirect:/furnizori";
    }
}
