package com.huawei.oss.mettingtools.Model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "users")
public class Users {
    private String text;
    private List<User> user = new ArrayList<User>();

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUserByName(String userName) {
        if(userName==null   ){
            return null;
        }
        for(User u: user){
            if(userName.equals(u.getName())){
                return u;
            }
        }
        return null;
    }
}

