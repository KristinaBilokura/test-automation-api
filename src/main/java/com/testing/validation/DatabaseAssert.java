package com.testing.validation;

import com.testing.fakes.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseAssert {
    private CrudRepository repository;

    public DatabaseAssert(CrudRepository repository) {
        this.repository = repository;
    }

    public void seeInDatabase(Map<String, Object> entity){
        if(!checkIfEntityExistInDatabase(entity))
            Assert.fail("Entity " + entity.toString() + " does not exist in com.testing.database");
    }

    public void cantSeeInDatabase(Map<String, Object> entity){
        if(checkIfEntityExistInDatabase(entity))
            Assert.fail("Entity " + entity.toString() + " still exist in com.testing.database");
    }

    public BaseEntity findById(Long id) throws Throwable {
        return (BaseEntity) repository.findById(id).orElseThrow(()-> new RuntimeException( "No entit were found with id " + id));
    }

    private boolean checkIfEntityExistInDatabase(Map<String, Object> entity){
        for (Map<String, Object>  map : convertObjectListToMapList((List<BaseEntity>) repository.findAll())) {
            int counter = 0;
            for(Map.Entry<String,Object> entry : entity.entrySet()){
                if(!(map.containsKey(entry.getKey()) && map.get(entry.getKey()).equals(entry.getValue())))
                    break;
                counter++;
            }
            if(counter==entity.entrySet().size()){
                return true;
            }
        }
        return false;
    }

    private List<Map<String, Object>> convertObjectListToMapList(List<BaseEntity> entities){
        List<Map<String,Object>> list = new ArrayList<>();
        for (BaseEntity entity: entities) {
            list.add(entity.map());
        }
        return list;
    }
}
