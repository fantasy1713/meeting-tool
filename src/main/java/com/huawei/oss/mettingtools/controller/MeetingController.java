package com.huawei.oss.mettingtools.controller;

import com.huawei.oss.mettingtools.Model.User;
import com.huawei.oss.mettingtools.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MeetingController {
    @Autowired
    private List<User> users;
    @Autowired
    private Users users1;

    @RequestMapping(value = "/filedir/{userName}/{dirName}")
    public List<String> getUrl(@PathVariable String userName, @PathVariable String dirName) {
        List<String> result = new ArrayList<String>();
        System.out.println(userName + ":" + dirName);
        users.size();
        users1.getUser();
        return result;
    }
}
