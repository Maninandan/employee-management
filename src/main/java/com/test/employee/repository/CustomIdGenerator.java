package com.test.employee.repository;

import com.test.employee.dao.Employee;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class CustomIdGenerator extends IdentityGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

        if ((((Employee) obj).getId()) == 0) {
            Serializable id = super.generate(session, obj);
            return id;
        } else {
            return ((Employee) obj).getId();

        }
    }

}
