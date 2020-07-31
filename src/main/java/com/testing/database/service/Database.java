package com.testing.database.service;

import com.testing.database.RepositoryEntityMap;
import com.testing.fakes.entity.BaseEntity;
import org.apache.log4j.Logger;
import org.springframework.data.repository.CrudRepository;
import com.testing.validation.DatabaseAssert;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {

    private final static Logger LOGGER = Logger.getLogger(Logger.class);
    private CrudRepository repository;

    public void haveInTable(BaseEntity entity){
        repository.save(entity);
        RepositoryEntityMap.addRepositoryToMap(entity, repository);
        LOGGER.info("Create precondition in com.testing.database " +
                " INSERT INTO " + getTableName(entity.getClass()) + ": " + entity.toString());
    }

    public Database cleanUpAllData(){

        Map<BaseEntity, CrudRepository> repositories = RepositoryEntityMap.getRepositoryMap();
        List<Map.Entry<BaseEntity, CrudRepository>> entryList = new ArrayList(repositories.entrySet());

        for (int i = entryList.size()-1; i>=0 ; i--) {
            BaseEntity entity = entryList.get(i).getKey();
            CrudRepository repository = entryList.get(i).getValue();
            repository.delete(entity);
            LOGGER.info("Delete precondition from com.testing.database " + " DELETE FROM "
                    + getTableName(entity.getClass()) + ": " + entity.toString() );
            repositories.remove(entryList.get(i).getKey(), entryList.get(i).getValue());
        }
        return this;
    }

    public Database setRepository(CrudRepository repository) {
        this.repository = repository;
        return this;
    }

    public DatabaseAssert assertion(){
        return new DatabaseAssert(repository);
    }

    private <T> String getTableName(Class<T> entity){
        Table table = entity.getAnnotation(Table.class);
        return table.name();
    }
}
