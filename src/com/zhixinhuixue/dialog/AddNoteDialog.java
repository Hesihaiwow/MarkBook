package com.zhixinhuixue.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;
import com.zhixinhuixue.entity.DataCenter;
import com.zhixinhuixue.entity.DataConvert;
import com.zhixinhuixue.entity.NoteData;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AddNoteDialog extends DialogWrapper {
    /**
     * 标题输入框
     */
    private EditorTextField etfTitle;
    /**
     * 内容输入框
     */
    private EditorTextField etfMark;


    public AddNoteDialog() {
        super(true);
        init();
        setTitle("添加笔记");
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        etfTitle = new EditorTextField("笔记标题");
        etfMark = new EditorTextField("笔记内容");
        etfMark.setPreferredSize(new Dimension(200, 100));
        panel.add(etfTitle, BorderLayout.NORTH);
        panel.add(etfMark, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("添加笔记");
        //按钮点击事件处理
        btnAdd.addActionListener(e -> {
            //获取标题
            String title = etfTitle.getText();
            //获取内容
            String mark = etfMark.getText();

            String currentFileName = DataCenter.CURRENT_FILE_NAME;
            String fileType = DataCenter.CURRENT_FILE_TYPE;
            String selectedText = DataCenter.SELECTED_TEXT;

            NoteData noteData = new NoteData(title, mark, currentFileName,fileType, selectedText);

            // 将笔记添加到集合中
            DataCenter.NOTE_LIST.add(noteData);

            // 将笔记添加到table中
            DataCenter.TABLE_MODEL.addRow(DataConvert.convert(noteData));
            MessageDialogBuilder.yesNo("操作结果","添加成功!").show();

            // 关闭弹窗方法
            AddNoteDialog.this.dispose();
        });
        panel.add(btnAdd);
        return panel;
    }
}

