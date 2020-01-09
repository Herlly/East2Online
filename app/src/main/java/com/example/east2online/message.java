package com.example.east2online;

public class message{
    private String name;
    private String message;
    public message(String name,String message){
        this.message=message;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public String getMessage(){
        return message;
    }
}
