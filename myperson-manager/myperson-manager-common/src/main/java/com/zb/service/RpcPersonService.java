package com.zb.service;

import com.zb.entity.Person;

import java.util.List;

public interface RpcPersonService {
    public List<Person> findPersonList();

    public void savePerson(Person p);

    public void deletePerson(Integer id);


}
