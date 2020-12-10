package com.zhixinhuixue.windows;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.zhixinhuixue.entity.DataCenter;
import com.zhixinhuixue.service.DefaultSourceNoteData;
import com.zhixinhuixue.service.MDFreeMarkProcessor;
import com.zhixinhuixue.service.Processor;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 通过swing的ui界面自动生成
 */
public class NoteListWindow {
    private JTextField tfTopic;
    private JTable tbContent;
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnClose;
    private JPanel jContent;

    public NoteListWindow(Project project, ToolWindow toolWindow) {

        /**
         * 初始化table_model
         */
        init();

        /**
         * 监听事件
         */
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tfTopic.getText();
                String fileName = text + ".md";
                if(StringUtils.isEmpty(text)){{
                    MessageDialogBuilder.yesNo("操作结果","文档标题没有输入");
                    return;
                }}else {
                    VirtualFile virtualFile = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFolderDescriptor(), project, project.getBaseDir());
                    if(virtualFile!=null){
                        String filePath = virtualFile.getPath() + "/" + fileName;

                        // 写文件接口
                        Processor processor = new MDFreeMarkProcessor();
                        try {

                            // 将 文档标题，文档路径 以及 笔记列表进行封装
                            processor.process(new DefaultSourceNoteData(tfTopic.getText(), filePath, DataCenter.NOTE_LIST));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                }

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataCenter.reset();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);

            }
        });
    }


    public JPanel getjContent(){
        return jContent;
    }

    public void init(){

        // 将table_model 的内容在对话框中展示
        tbContent.setModel(DataCenter.TABLE_MODEL);
        tbContent.setEnabled(true);
    }

}
