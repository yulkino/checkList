package task9.checkList.controllers;

import jdk.jfr.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import task9.checkList.services.CheckListService;

@Controller
public class DeletingItemController {

    @Autowired
    public CheckListService checkListService;

    @PostMapping("/{name}")
    public String deletingPointFromCheckList(@PathVariable("name") String name){
        checkListService.removeItemFromCheckList(name);
        return "redirect:/";
    }
}