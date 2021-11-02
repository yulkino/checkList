package task9.checkList.services;

import org.springframework.stereotype.Service;
import task9.checkList.models.Item;

import java.util.HashSet;
import java.util.Set;

@Service
public class CheckListService {

    private Set<Item> checkList = new HashSet<Item>();{
        checkList.add(new Item("Мёд"));
        checkList.add(new Item("Сыр"));
        checkList.add(new Item("Хлеб"));
        checkList.add(new Item("Чебупели"));
    }

    public void addItemInCheckList(String name){
        checkList.add(new Item(name));
    }

    public void removeItemFromCheckList(String name){
        var item = checkList.stream().filter(x -> x.getItemName().equals(name)).findFirst();
        if(item.isPresent())
            checkList.remove(item.get());
    }

    public Set<Item> getCheckList() {
        return checkList;
    }

}
