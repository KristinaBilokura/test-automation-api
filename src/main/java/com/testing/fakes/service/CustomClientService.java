package com.testing.fakes.service;

import com.testing.fakes.repository.CustomClientRepository;
import com.testing.database.service.Database;
import com.testing.fakes.entity.BaseEntity;
import com.testing.fakes.entity.CustomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomClientService extends BaseService {

    @Autowired
    private CustomClientRepository customClientRepository;

    @Override
    public CustomClient create(BaseEntity entity) {
        CustomClient customClient = (CustomClient) entity;
        database().haveInTable(customClient);
        return customClient;
    }

    @Override
    public CustomClient create() {
        CustomClient customClient = getEntity();
        database().haveInTable(customClient);
        return customClient;
    }

    @Override
    public CustomClient getEntity() {
        return new CustomClient()
                .setCountry("Ukraine")
                .setCity("Dnipro")
                .setFirstName("test first name")
                .setLastName("test last name");
    }

    @Override
    public Database database() {
        return database.setRepository(customClientRepository);
    }
}
