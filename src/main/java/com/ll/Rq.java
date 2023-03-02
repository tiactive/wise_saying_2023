package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode;
    private Map<String, String> params;

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);
        String actionCode = commandBits[0];
        Map<String, String> params = new HashMap<>();
        String[] paramBits = commandBits[1].split("&");
        for(String paramStr:paramBits) {
            String[] paramStrBits = paramStr.split("=", 2);
            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key,value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }
}
