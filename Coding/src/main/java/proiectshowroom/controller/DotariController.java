package proiectshowroom.controller;


import proiectshowroom.dao.DotariDAO;
import proiectshowroom.model.Dotari;
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
public class DotariController {

    @Autowired
    private DotariDAO dao;

    @RequestMapping("/dotari")
    public String viewHomePage(Model model) {
        List<Dotari> listaDotari = dao.list();
        model.addAttribute("listaDotari", listaDotari);

        return "dotari/show";
    }

    @RequestMapping("/dotari/new")
    public String showNewForm(Model model) {
        Dotari dotare = new Dotari();
        model.addAttribute("dotare", dotare);

        return "dotari/new_form";
    }

    @RequestMapping(value = "/dotari/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Dotari") Dotari dotare) {
        dao.save(dotare);

        return "redirect:/dotari";
    }

    @RequestMapping("/dotari/edit/{id_dotare}")
    public ModelAndView showEditForm(@PathVariable(name = "id_dotare") Integer id_dotare) {
        ModelAndView mav = new ModelAndView("dotari/edit_form");
        Dotari dotare = dao.get(id_dotare);
        mav.addObject("dotare", dotare);

        return mav;
    }

    @RequestMapping(value = "/dotari/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Dotari") Dotari dotare) {
        dao.update(dotare);

        return "redirect:/dotari";
    }

    @RequestMapping("/dotari/delete/{id_dotare}")
    public String delete(@PathVariable(name = "id_dotare") Integer id_dotare) {
        dao.delete(id_dotare);

        return "redirect:/dotari";
    }
}
