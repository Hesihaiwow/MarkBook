package com.zhixinhuixue.service;

import com.zhixinhuixue.entity.NoteData;

import java.nio.channels.Pipe;
import java.util.List;

public class DefaultSourceNoteData implements SourceNoteData {

    public String topic;

    public List<NoteData> noteList;

    public String filePath;

    public DefaultSourceNoteData(String topic,String filePath,List<NoteData> noteList){
        this.topic = topic;
        this.noteList = noteList;
        this.filePath = filePath;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public List<NoteData> getNoteList() {
        return noteList;
    }

    @Override
    public String getFilePath(){
        return filePath;
    }
}
