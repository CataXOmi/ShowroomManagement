package proiectshowroom.controller;

import proiectshowroom.dao.TariDAO;
import proiectshowroom.model.Tari;
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
public class TariController {

    @Autowired
    private TariDAO dao;

    @RequestMapping("/tari")
    public String viewHomePage(Model model) {
        List<Tari> listaTari = dao.list();
        model.addAttribute("listaTari", listaTari);

        return "tari/show";
    }

    @RequestMapping("/tari/new")
    public String showNewForm(Model model) {
        Tari tara = new Tari();
        model.addAttribute("tara", tara);

        return "tari/new_form";
    }

    @RequestMapping(value = "/tari/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Tari") Tari tara) {
        dao.save(tara);

        return "redirect:/tari";
    }

    @RequestMapping("/tari/edit/{id_tara}")
    public ModelAndView showEditForm(@PathVariable(name = "id_tara") Integer id_tara) {
        ModelAndView mav = new ModelAndView("tari/edit_form");
        Tari tara = dao.get(id_tara);
        mav.addObject("tara", tara);

        return mav;
    }

    @RequestMapping(value = "/tari/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Tari") Tari tara) {
        dao.update(tara);

        return "redirect:/tari";
    }

    @RequestMapping("/tari/delete/{id_tara}")
    public String delete(@PathVariable(name = "id_tara") Integer id_tara) {
        dao.delete(id_tara);

        return "redirect:/tari";
    }
}
