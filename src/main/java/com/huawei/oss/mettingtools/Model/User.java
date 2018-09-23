package com.huawei.oss.mettingtools.Model;

import java.util.HashMap;
import java.util.Map;

//@Component
//@ConfigurationProperties(prefix = "users.user")
public class User {
    private String name;
    private Map<String, String> filePath = new HashMap<String, String>();

    public Map<String, String> getFilePath() {
        return filePath;
    }

    public void setFilePath(Map<String, String> filePath) {
        this.filePath = filePath;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
