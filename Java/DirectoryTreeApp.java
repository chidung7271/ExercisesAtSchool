

import java.io.IOException;
import java.nio.file.Path;

import javax.swing.tree.DefaultMutableTreeNode;

public class DirectoryTreeApp {
    public static void main(String[] args) throws IOException {
        FirstGui gui = new FirstGui();
        Path link = gui.Data();
        // Path link = Paths.get("D:\\This PC\\Documents");
        DirectoryTreeModel model = new DirectoryTreeModel();
        DefaultMutableTreeNode root = model.createNodes(link);
        DirectoryTreeView view = new DirectoryTreeView(root);
        DirectoryTreeController controller = new DirectoryTreeController(model, view , gui);
        controller.showView();
    }
}