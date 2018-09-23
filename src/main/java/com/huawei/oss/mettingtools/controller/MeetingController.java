package com.huawei.oss.mettingtools.controller;

import com.huawei.oss.mettingtools.Model.User;
import com.huawei.oss.mettingtools.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MeetingController {

    @Autowired
    private Users users;

    @RequestMapping(value = {"/filedir/","/filedir/{userName}"})
    public List<String> getUrl(@PathVariable(required = false) String userName) {
        List<String> result = new ArrayList<>();

        if (userName == null) {
            List<User> all = users.getUser();
            for (User u : all) {
                result.add(u.getName());
            }
        } else {
            User user = users.getUserByName(userName);
            if (user == null) {
                return result;
            } else {
                Map<String, String> map = user.getFilePath();
                for (Map.Entry<String, String> en : map.entrySet()) {
                    result.add(en.getKey() + ":" + en.getValue());
                }
            }
        }
        return result;
    }
}
