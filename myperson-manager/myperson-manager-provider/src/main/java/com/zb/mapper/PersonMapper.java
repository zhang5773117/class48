package com.zb.mapper;

import com.zb.entity.Person;

import java.util.List;

public interface PersonMapper {
    public List<Person> findPersonList();

    public void savePerson(Person p);

    public void deletePerson(Integer id);
}
