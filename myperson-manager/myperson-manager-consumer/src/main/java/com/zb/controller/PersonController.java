package com.zb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zb.entity.Person;
import com.zb.service.RpcPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {
    @Reference(timeout = 10000)
    private RpcPersonService rpcPersonService;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }


    @RequestMapping(value = "/show")
    @ResponseBody
    public List<Person> show(){
        return rpcPersonService.findPersonList();
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(){
        Person p = new Person();
        p.setName("张飞");
        p.setAge(20);
        p.setAddress("河南");
        rpcPersonService.savePerson(p);
        return "ok";
    }


}
