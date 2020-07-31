package com.testing.database;

import com.testing.fakes.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepositoryEntityMap {
    private static Map<BaseEntity, CrudRepository> repositoryMap = new LinkedHashMap();

    public static void addRepositoryToMap(BaseEntity entity, CrudRepository crudRepository){
        repositoryMap.put(entity, crudRepository);
    }

    public static Map getRepositoryMap() {
        return repositoryMap;
    }
}
