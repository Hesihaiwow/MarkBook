package com.zhixinhuixue.service;

import com.zhixinhuixue.entity.NoteData;

import java.util.List;

public interface SourceNoteData {

    public String getTopic();

    public List<NoteData> getNoteList();

    public String getFilePath();
}
