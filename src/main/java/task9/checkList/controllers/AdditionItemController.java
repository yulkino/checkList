package task9.checkList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import task9.checkList.services.CheckListService;

@Controller
public class AdditionItemController {

    @Autowired
    public CheckListService checkListService;

    @GetMapping("/add")
    public String create(Model model) {
        model.addAttribute("pageName", "Новый продукт");
        return "additionInCheckList";
    }


    @PostMapping("/add")
    public String addPointInCheckList(@ModelAttribute("text") String name){
        if (!name.equals("")) {
            checkListService.addItemInCheckList(name);
        }
        return "redirect:/";
    }
}
