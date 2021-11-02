package task9.checkList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import task9.checkList.services.CheckListService;

@Controller
public class CheckListController {

    @Autowired
    public CheckListService checkListService;

    @GetMapping("/")
    public String CheckList(Model model){
        model.addAttribute("pageName", "Список покупок");
        model.addAttribute("checkList", checkListService.getCheckList());
        return "checkList";
    }

}
