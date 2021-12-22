package task9.checkList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task9.checkList.models.Item;
import task9.checkList.services.CheckListService;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    public CheckListService checkListService;

    @GetMapping
    public ResponseEntity<List<Item>> getItems() {
        var items = checkListService.getCheckList();
        return items == null
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addPointInCheckList(@RequestBody Item item){
        if (item.getName().equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            checkListService.addItemInCheckList(item);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{name}")
    public ResponseEntity<?> deletingPointFromCheckList(@PathVariable String name){
        if (checkListService.removeItemFromCheckList(name)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}