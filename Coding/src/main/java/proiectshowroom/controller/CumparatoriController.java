package proiectshowroom.controller;

import proiectshowroom.dao.CumparatoriDAO;
import proiectshowroom.model.Cumparatori;
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
public class CumparatoriController {

    @Autowired
    private CumparatoriDAO dao;

    @RequestMapping("/cumparatori")
    public String viewHomePage(Model model) {
        List<Cumparatori> listaCumparatori = dao.list();
        model.addAttribute("listaCumparatori", listaCumparatori);

        return "cumparatori/show";
    }

    @RequestMapping("/cumparatori/new")
    public String showNewForm(Model model) {
        Cumparatori cumparator = new Cumparatori();
        model.addAttribute("cumparator", cumparator);

        return "cumparatori/new_form";
    }

    @RequestMapping(value = "/cumparatori/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Cumparatori") Cumparatori cumparator) {
        dao.save(cumparator);

        return "redirect:/cumparatori";
    }

    @RequestMapping("/cumparatori/edit/{id_cumparator}")
    public ModelAndView showEditForm(@PathVariable(name = "id_cumparator") Integer id_cumparator) {
        ModelAndView mav = new ModelAndView("cumparatori/edit_form");
        Cumparatori cumparator = dao.get(id_cumparator);
        mav.addObject("cumparator", cumparator);

        return mav;
    }

    @RequestMapping(value = "/cumparatori/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Cumparatori") Cumparatori cumparator) {
        dao.update(cumparator);

        return "redirect:/cumparatori";
    }

    @RequestMapping("/cumparatori/delete/{id_cumparator}")
    public String delete(@PathVariable(name = "id_cumparator") Integer id_cumparator) {
        dao.delete(id_cumparator);

        return "redirect:/cumparatori";
    }

}
