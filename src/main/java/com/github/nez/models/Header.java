package com.github.nez.models;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public enum Header {

    TWITCH("REACT_APP_TWITCH_CLIENT_ID", "REACT_APP_TWITCH_SECRET"),
    DISCORD,
    TWITTER("SPRING_TWITTER_CONSUMER_KEY", "SPRING_TWITTER_ACCESS_TOKEN"),
    FACEBOOK,
    MIXER;

    private Map<String,String> body;

    Header(String... headerElements){
        this.body = new HashMap<>();
        for (String element: headerElements){
            this.body.put(element,System.getenv(element));
        }
    }

    public JSONObject getBody() {
        return new JSONObject(body);
    }

    public void addHeaderItem(String item){
        this.body.put(item,System.getenv(item));
    }

    public String getHeaderItem(String itemName){
        return this.body.get(itemName);
    }

}


