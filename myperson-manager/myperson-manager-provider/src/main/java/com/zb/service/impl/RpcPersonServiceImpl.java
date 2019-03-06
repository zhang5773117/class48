package com.zb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.zb.entity.Person;
import com.zb.mapper.PersonMapper;
import com.zb.service.RpcPersonService;
import com.zb.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = RpcPersonService.class)
public class RpcPersonServiceImpl implements RpcPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<Person> findPersonList() {
        String key = "plist";
        List<Person> list = null;
        if(redisUtils.validate(key)){
            String json = redisUtils.get(key).toString();
            list= JSON.parseArray(json,Person.class);
        }else{
            list = personMapper.findPersonList();
            redisUtils.set(key,JSON.toJSONString(list));
        }
        return list;
    }

    @Override
    @Transactional
    public void savePerson(Person p) {
        personMapper.savePerson(p);
        this.deletePerson(1);

    }

    @Transactional
    @Override
    public void deletePerson(Integer id) {
        throw new RuntimeException("删除报错了~~~");
        //personMapper.deletePerson(id);
    }
}
