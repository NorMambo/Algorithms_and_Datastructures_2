package Task3;

import java.io.File;
import java.io.IOException;

public class LCRS_Tree {
    FileNode rootNode;

    public LCRS_Tree(FileNode rootNode) {
        this.rootNode = rootNode;
        this.rootNode.status = Labels.ROOT.status;
    }

    public void createTree() {
        rootNode.addAllChildNodes(rootNode);
    }

    public boolean nodeExists(String nodePath) {
        return rootNode.nodeExists(nodePath, false);
    }

    public FileNode findNodeByPath(String targetPath) {
        return rootNode.findNodeByPath(targetPath, rootNode, null);
    }

    public FileNode findNodeByName(String filename) {
        return rootNode.findNodeByName(filename, rootNode, null);
    }

    public void addNodeToExistingNode(String exFilePath, String newFileName) throws IOException {

        File exFile = new File(exFilePath);
        File newFile = new File(exFilePath + "/" + newFileName);

        if (!exFile.isDirectory()) {
            System.out.println("Can't left child. Existing file is not a directory.\n");
            return;
        }
        if (newFile.exists()) {
            System.out.println("Can't add, file already exists in this folder.\n");
            return;
        }
        newFile.createNewFile();
        FileNode n = rootNode.findNodeByPath(exFilePath, rootNode, null);
        rootNode.addChildToNode(n, newFileName);
    }

    public void walkTree() {
        rootNode.walk();
    }
}
