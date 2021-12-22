package task9.checkList.services;

import org.springframework.stereotype.Service;
import task9.checkList.models.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CheckListService {

    private Set<Item> checkList = new HashSet<>();{
        checkList.add(new Item("Мёд"));
        checkList.add(new Item("Сыр"));
        checkList.add(new Item("Хлеб"));
        checkList.add(new Item("Чебупели"));
    }

    public void addItemInCheckList(Item item){
        checkList.add(item);
    }

    public boolean removeItemFromCheckList(String name){
        var item = checkList.stream().filter(x -> x.getName().equals(name)).findFirst();
        var result = item.isPresent();
        item.ifPresent(value -> checkList.remove(value));
        return result;
    }

    public List<Item> getCheckList() {
        return new ArrayList<>(checkList);
    }

}
