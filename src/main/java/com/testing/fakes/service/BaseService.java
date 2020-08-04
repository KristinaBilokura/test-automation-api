package com.testing.fakes.service;

import com.testing.database.service.Database;
import com.testing.fakes.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService{

    @Autowired
    protected Database database;

    public abstract BaseEntity create(BaseEntity entity);
    public abstract BaseEntity create();
    public abstract BaseEntity getEntity();
    public abstract Database database();
}
