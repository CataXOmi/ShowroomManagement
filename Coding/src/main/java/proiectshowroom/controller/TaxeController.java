package proiectshowroom.controller;

import proiectshowroom.dao.TaxeDAO;
import proiectshowroom.model.Taxe;
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
public class TaxeController {

    @Autowired
    private TaxeDAO dao;

    @RequestMapping("/taxe")
    public String viewHomePage(Model model) {
        List<Taxe> listaTaxe = dao.list();
        model.addAttribute("listaTaxe", listaTaxe);

        return "taxe/show";
    }

    @RequestMapping("/taxe/new")
    public String showNewForm(Model model) {
        Taxe taxa = new Taxe();
        model.addAttribute("taxa", taxa);

        return "taxe/new_form";
    }

    @RequestMapping(value = "/taxe/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Taxe") Taxe taxa) {
        dao.save(taxa);

        return "redirect:/taxe";
    }

    @RequestMapping("/taxe/edit/{id_taxa}")
    public ModelAndView showEditForm(@PathVariable(name = "id_taxa") Integer id_taxa) {
        ModelAndView mav = new ModelAndView("taxe/edit_form");
        Taxe taxa = dao.get(id_taxa);
        mav.addObject("taxa", taxa);

        return mav;
    }

    @RequestMapping(value = "/taxe/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Taxe") Taxe taxa) {
        dao.update(taxa);

        return "redirect:/taxe";
    }

    @RequestMapping("/taxe/delete/{id_taxa}")
    public String delete(@PathVariable(name = "id_taxa") Integer id_taxa) {
        dao.delete(id_taxa);

        return "redirect:/taxe";
    }
}
