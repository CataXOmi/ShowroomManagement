package proiectshowroom.controller;

import proiectshowroom.dao.FacturiDAO;
import proiectshowroom.model.Facturi;
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
public class FacturiController {

    @Autowired
    private FacturiDAO dao;

    @RequestMapping("/facturi")
    public String viewHomePage(Model model) {
        List<Facturi> listaFacturi = dao.list();
        model.addAttribute("listaFacturi", listaFacturi);

        return "facturi/show";
    }

    @RequestMapping("/facturi/new")
    public String showNewForm(Model model) {
        Facturi factura = new Facturi();
        model.addAttribute("factura", factura);

        return "facturi/new_form";
    }

    @RequestMapping(value = "/facturi/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Facturi") Facturi factura) {
        dao.save(factura);

        return "redirect:/facturi";
    }

    @RequestMapping("/facturi/edit/{id_taxa}/{id_masina}")
    public ModelAndView showEditForm(@PathVariable(name = "id_taxa") Integer id_taxa, @PathVariable(name = "id_masina") Integer id_masina) {
        ModelAndView mav = new ModelAndView("facturi/edit_form");
        Facturi factura = dao.get(id_taxa,id_masina);
        mav.addObject("factura", factura);

        return mav;
    }

    @RequestMapping(value = "/facturi/update/{id_taxa_anterioara}/{id_masina_anterioara}", method = RequestMethod.POST)
    public String update(@ModelAttribute("Facturi") Facturi factura, @PathVariable(name = "id_taxa_anterioara") Integer id_taxa_anterioara, @PathVariable(name = "id_masina_anterioara") Integer id_masina_anterioara) {
        dao.update(factura, id_taxa_anterioara, id_masina_anterioara);

        return "redirect:/facturi";
    }

    @RequestMapping("/facturi/delete/{id_taxa}/{id_masina}")
    public String delete(@PathVariable(name = "id_taxa") Integer id_taxa, @PathVariable(name = "id_masina") Integer id_masina) {
        dao.delete(id_taxa,id_masina);

        return "redirect:/facturi";
    }
}
