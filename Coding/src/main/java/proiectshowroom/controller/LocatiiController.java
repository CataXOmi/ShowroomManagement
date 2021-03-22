package proiectshowroom.controller;

import proiectshowroom.dao.LocatiiDAO;
import proiectshowroom.model.Locatii;
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
public class LocatiiController {

    @Autowired
    private LocatiiDAO dao;

    @RequestMapping("/locatii")
    public String viewHomePage(Model model) {
        List<Locatii> listaLocatii = dao.list();
        model.addAttribute("listaLocatii", listaLocatii);

        return "locatii/show";
    }

    @RequestMapping("/locatii/new")
    public String showNewForm(Model model) {
        Locatii locatie = new Locatii();
        model.addAttribute("locatie", locatie);

        return "locatii/new_form";
    }

    @RequestMapping(value = "/locatii/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Locatii") Locatii locatie) {
        dao.save(locatie);

        return "redirect:/locatii";
    }

    @RequestMapping("/locatii/edit/{id_locatie}")
    public ModelAndView showEditForm(@PathVariable(name = "id_locatie") Integer id_locatie) {
        ModelAndView mav = new ModelAndView("locatii/edit_form");
        Locatii locatie = dao.get(id_locatie);
        mav.addObject("locatie", locatie);

        return mav;
    }

    @RequestMapping(value = "/locatii/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Locatii") Locatii locatie) {
        dao.update(locatie);

        return "redirect:/locatii";
    }

    @RequestMapping("/locatii/delete/{id_locatie}")
    public String delete(@PathVariable(name = "id_locatie") Integer id_locatie) {
        dao.delete(id_locatie);

        return "redirect:/locatii";
    }
}
