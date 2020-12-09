package com.zhixinhuixue.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.zhixinhuixue.dialog.AddNoteDialog;
import com.zhixinhuixue.entity.DataCenter;

/**
 *
 * 右键弹出的action
 */
public class PopupAction extends AnAction {


    /**
     * 获取已经选中的文本内容
     *
     * @param e
     */
    @Override
    public void actionPerformed(AnActionEvent e) {

        //获取当前编辑器对象
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        //获取选择的数据模型
        SelectionModel selectionModel = editor.getSelectionModel();
        //获取当前选择的文本
        String selectedText = selectionModel.getSelectedText();
//        System.out.println(selectedText);

        //选择的内容
        DataCenter.SELECTED_TEXT = selectedText;

        //文件名称
        DataCenter.CURRENT_FILE_NAME = e.getRequiredData(CommonDataKeys.PSI_FILE).getViewProvider().getVirtualFile().getName();
        DataCenter.CURRENT_FILE_TYPE =DataCenter.CURRENT_FILE_NAME.substring(DataCenter.CURRENT_FILE_NAME.lastIndexOf(".")+1);

        AddNoteDialog addNoteDialog = new AddNoteDialog();

        addNoteDialog.show();


    }
}
