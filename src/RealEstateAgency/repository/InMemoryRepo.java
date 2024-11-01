package RealEstateAgency.repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RealEstateAgency.model.HasID;

public class InMemoryRepo<T extends HasID> implements Repository<T>{
    private Map<Integer,T> data=new HashMap<>();
    @Override
    public void create(T obj) {
        data.putIfAbsent(obj.getId(), obj);
    }

    @Override
    public T get(Integer id) {
        return data.get(id);
    }

    @Override
    public void update(T obj) {
        data.replace(obj.getId(), obj);
    }

    @Override
    public void delete(Integer id) {
       data.remove(id);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }

}
