package proiectshowroom.controller;

import proiectshowroom.dao.MasiniDAO;
import proiectshowroom.model.Masini;
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
public class MasiniController {

    @Autowired
    private MasiniDAO dao;

    @RequestMapping("/masini")
    public String viewHomePage(Model model) {
        List<Masini> listaMasini = dao.list();
        model.addAttribute("listaMasini", listaMasini);

        return "masini/show";
    }

    @RequestMapping("/masini/new")
    public String showNewForm(Model model) {
        Masini masina = new Masini();
        model.addAttribute("masina", masina);

        return "masini/new_form";
    }

    @RequestMapping(value = "/masini/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Masini") Masini masina) {
        dao.save(masina);

        return "redirect:/masini";
    }

    @RequestMapping("/masini/edit/{id_masina}")
    public ModelAndView showEditForm(@PathVariable(name = "id_masina") Integer id_masina) {
        ModelAndView mav = new ModelAndView("masini/edit_form");
        Masini masina = dao.get(id_masina);
        mav.addObject("masina", masina);

        return mav;
    }

    @RequestMapping(value = "/masini/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Masini") Masini masina) {
        dao.update(masina);

        return "redirect:/masini";
    }

    @RequestMapping("/masini/delete/{id_masina}")
    public String delete(@PathVariable(name = "id_masina") Integer id_masina) {
        dao.delete(id_masina);

        return "redirect:/masini";
    }
}
