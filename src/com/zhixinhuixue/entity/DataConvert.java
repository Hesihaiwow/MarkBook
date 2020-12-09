package com.zhixinhuixue.entity;

public class DataConvert {

    public static String[] convert(NoteData noteData){
        String[] strings = new String[4];

        String content = noteData.getContent();
        String title = noteData.getTitle();
        String mark = noteData.getMark();
        String fileName = noteData.getFileName();
        strings[0] = title;
        strings[1] = mark;
        strings[2] = fileName;
        strings[3] = content;

        return strings;
    }
}
