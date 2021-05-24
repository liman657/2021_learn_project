package com.learn.springsourcedemo.demo.pattern.template;

public class TemplateDemo {
    public static void main(String[] args) {
        KTVRoom room1 = new RoomForChineseSinger();
        room1.procedure();
        KTVRoom room2 = new RoomForAmericanSinger();
        room2.procedure();
    }
}
