package com.zhixinhuixue.service;

import com.zhixinhuixue.entity.NoteData;

import java.nio.channels.Pipe;
import java.util.List;

public class DefaultSourceNoteData implements SourceNoteData {

    public String topic;

    public List<NoteData> noteList;

    public String filePath;

    public DefaultSourceNoteData(String topic,List<NoteData> noteList){
        this.topic = topic;
        this.noteList = noteList;
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
