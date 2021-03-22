package proiectshowroom.controller;

import proiectshowroom.dao.ShowroomuriDAO;
import proiectshowroom.model.Showroomuri;
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
public class ShowroomuriController {

    @Autowired
    private ShowroomuriDAO dao;

    @RequestMapping("/showroomuri")
    public String viewHomePage(Model model) {
        List<Showroomuri> listaShowroomuri = dao.list();
        model.addAttribute("listaShowroomuri", listaShowroomuri);

        return "showroomuri/show";
    }

    @RequestMapping("/showroomuri/new")
    public String showNewForm(Model model) {
        Showroomuri showroom = new Showroomuri();
        model.addAttribute("showroom", showroom);

        return "showroomuri/new_form";
    }

    @RequestMapping(value = "/showroomuri/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Showroomuri") Showroomuri showroom) {
        dao.save(showroom);

        return "redirect:/showroomuri";
    }

    @RequestMapping("/showroomuri/edit/{id_showroom}")
    public ModelAndView showEditForm(@PathVariable(name = "id_showroom") Integer id_showroom) {
        ModelAndView mav = new ModelAndView("showroomuri/edit_form");
        Showroomuri showroom = dao.get(id_showroom);
        mav.addObject("showroom", showroom);

        return mav;
    }

    @RequestMapping(value = "/showroomuri/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Showroomuri") Showroomuri showroom) {
        dao.update(showroom);

        return "redirect:/showroomuri";
    }

    @RequestMapping("/showroomuri/delete/{id_showroom}")
    public String delete(@PathVariable(name = "id_showroom") Integer id_showroom) {
        dao.delete(id_showroom);

        return "redirect:/showroomuri";
    }
}
