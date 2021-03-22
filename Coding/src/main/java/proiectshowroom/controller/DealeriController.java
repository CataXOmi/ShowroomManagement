package proiectshowroom.controller;

import proiectshowroom.dao.DealeriDAO;
import proiectshowroom.model.Dealeri;
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
public class DealeriController {

    @Autowired
    private DealeriDAO dao;

    @RequestMapping("/dealeri")
    public String viewHomePage(Model model) {
        List<Dealeri> listaDealeri = dao.list();
        model.addAttribute("listaDealeri", listaDealeri);

        return "dealeri/show";
    }

    @RequestMapping("/dealeri/new")
    public String showNewForm(Model model) {
        Dealeri dealer = new Dealeri();
        model.addAttribute("dealer", dealer);

        return "dealeri/new_form";
    }

    @RequestMapping(value = "/dealeri/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Dealeri") Dealeri dealer) {
        dao.save(dealer);

        return "redirect:/dealeri";
    }

    @RequestMapping("/dealeri/edit/{id_dealer}")
    public ModelAndView showEditForm(@PathVariable(name = "id_dealer") Integer id_dealer) {
        ModelAndView mav = new ModelAndView("dealeri/edit_form");
        Dealeri dealer = dao.get(id_dealer);
        mav.addObject("dealer", dealer);

        return mav;
    }

    @RequestMapping(value = "/dealeri/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Dealeri") Dealeri dealer) {
        dao.update(dealer);

        return "redirect:/dealeri";
    }

    @RequestMapping("/dealeri/delete/{id_dealer}")
    public String delete(@PathVariable(name = "id_dealer") Integer id_dealer) {
        dao.delete(id_dealer);

        return "redirect:/dealeri";
    }
}
