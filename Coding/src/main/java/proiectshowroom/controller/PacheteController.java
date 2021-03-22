package proiectshowroom.controller;

import proiectshowroom.dao.PacheteDAO;
import proiectshowroom.model.Pachete;
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
public class PacheteController {

    @Autowired
    private PacheteDAO dao;

    @RequestMapping("/pachete")
    public String viewHomePage(Model model) {
        List<Pachete> listaPachete = dao.list();
        model.addAttribute("listaPachete", listaPachete);

        return "pachete/show";
    }

    @RequestMapping("/pachete/new")
    public String showNewForm(Model model) {
        Pachete pachet = new Pachete();
        model.addAttribute("pachet", pachet);

        return "pachete/new_form";
    }

    @RequestMapping(value = "/pachete/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Pachete") Pachete pachet) {
        dao.save(pachet);

        return "redirect:/pachete";
    }

    @RequestMapping("/pachete/edit/{id_dotare}/{id_masina}")
    public ModelAndView showEditForm(@PathVariable(name = "id_dotare") Integer id_dotare, @PathVariable(name = "id_masina") Integer id_masina) {
        ModelAndView mav = new ModelAndView("pachete/edit_form");
        Pachete pachet = dao.get(id_dotare,id_masina);
        mav.addObject("pachet", pachet);

        return mav;
    }

    @RequestMapping(value = "/pachete/update/{id_dotare_anterioara}/{id_masina_anterioara}", method = RequestMethod.POST)
    public String update(@ModelAttribute("Pachete") Pachete pachet, @PathVariable(name = "id_dotare_anterioara") Integer id_dotare_anterioara, @PathVariable(name = "id_masina_anterioara") Integer id_masina_anterioara) {
        dao.update(pachet, id_dotare_anterioara, id_masina_anterioara);

        return "redirect:/pachete";
    }

    @RequestMapping("/pachete/delete/{id_dotare}/{id_masina}")
    public String delete(@PathVariable(name = "id_dotare") Integer id_dotare, @PathVariable(name = "id_masina") Integer id_masina) {
        dao.delete(id_dotare,id_masina);

        return "redirect:/pachete";
    }
}
