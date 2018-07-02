package actions;

import com.intellij.ide.IdeView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.psi.JavaDirectoryService;
import com.intellij.psi.PsiDirectory;

import java.util.HashMap;
import java.util.Map;

public class MvpGenerator extends AnAction implements MvpHandler.OnGenerateListener {

    private AnActionEvent actionEvent;
    private MvpHandler mvpHandler;
    private Map<String, String> map = new HashMap<>();

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        this.actionEvent = anActionEvent;
        mvpHandler = new MvpHandler();
        mvpHandler.setTitle("输入名称-生成MVP相关类");
        mvpHandler.setOnGenerateListener(this);
        mvpHandler.pack();
        //设置对话框跟随当前windows窗口
        mvpHandler.setLocationRelativeTo(WindowManager.getInstance().getFrame(anActionEvent.getProject()));
        mvpHandler.setVisible(true);
    }


    @Override
    public void onGenerate(String text) {

        JavaDirectoryService directoryService = JavaDirectoryService.getInstance();

        //当前工程
        Project project = actionEvent.getProject();
        map.put("NAME", text);
        map.put("PACKAGE_NAME", Util.getPackageName(project));

        //鼠标右键所选择的路径
        IdeView ideView = actionEvent.getRequiredData(LangDataKeys.IDE_VIEW);
        PsiDirectory directory = ideView.getOrChooseDirectory();

        assert directory != null;
        if (directory.getName().contains("contract") && directory.findFile(text + "Contract.java") == null) {
            directoryService.createClass(directory, text + "Contract", "GenerateContractFile", true, map);
        }

        if (directory.getName().contains("model") && directory.findFile(text + "Model.java") == null) {
            directoryService.createClass(directory, text + "Model", "GenerateModelFile", true, map);
        }

        if (directory.getName().contains("presenter") && directory.findFile(text + "Presenter.java") == null) {
            directoryService.createClass(directory, text + "Presenter", "GeneratePresenterFile", true, map);
        }

        mvpHandler.setVisible(false);
    }

    @Override
    public void onCancel() {
        mvpHandler.setVisible(false);
    }
}
