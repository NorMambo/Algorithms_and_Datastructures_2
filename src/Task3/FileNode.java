package Task3;

import java.io.File;

public class FileNode {
    public String rootpath;
    public String filename;
    public String pathWithFilename;
    public FileNode leftChild;
    public FileNode rightSibling;
    public String status;

    public FileNode(String rootpath, String filename) {
        this.filename = filename;
        this.rootpath = rootpath;
        pathWithFilename = rootpath + "/" + filename;
    }

    public String[] getContentArray(String path) {
        File f = new File(path);
        return f.list();
    }

    public void addAllChildNodes(FileNode curr) {

        String[] dirContent = getContentArray(curr.pathWithFilename); //<- get dir content String array
        int i = 0; //<- i is used to iterate through the content of the String array
        FileNode p = null; //<- p is previous FileNode

        while (dirContent != null && i < dirContent.length) { //<- if there is content, and we haven't finished iterating through the content

            if (curr.leftChild == null) { //<- if current FileNode has no leftChild
                curr.leftChild = new FileNode(curr.pathWithFilename,dirContent[i]); //<- make the first element of the directory content leftChild
                curr.leftChild.status = Labels.LEFT.status + " of " + curr.filename; //<- set the label for the printout
                p = curr.leftChild; //<- p (previous) now equal to leftChild
                addAllChildNodes(curr.leftChild); //<- recursive call

            } else { //<- if leftChild != null
                p.rightSibling = new FileNode(p.rootpath,dirContent[i]); //<- make the following elements of the content directory the right siblings
                p.rightSibling.status = Labels.RIGHT.status + " of " + p.filename; //<- set label for the printout
                addAllChildNodes(p.rightSibling); //<- recursive call
                p = p.rightSibling; //<- p (previous) now equal to previous.rightSibling
            }
            i++; //<- increment to get next value of directory content in current recursive level
        }
    }

    public void addChildToNode(FileNode existing, String newFileName) {
        FileNode n = new FileNode(existing.pathWithFilename, newFileName);
        if (existing.leftChild != null) {
            n.rightSibling = existing.leftChild;
            n.rightSibling.status = Labels.RIGHT.status + " of " + existing.filename;
        }
        n.status = Labels.LEFT.status + " of " + existing.filename;
        existing.leftChild = n;
    }

    public boolean nodeExists(String target, boolean exists) {
        if (!filename.equals(target)) {
            if (leftChild != null)
                    exists = leftChild.nodeExists(target, exists);
            if (rightSibling != null)
                    exists = rightSibling.nodeExists(target, exists);
        } else {
            exists = true;
        }
        return exists;
    }

    public FileNode findNodeByPath(String target, FileNode current, FileNode res) {
        if (res == null) {
            if (current != null && !current.pathWithFilename.equals(target)) {
                if (current.leftChild != null)
                    res = findNodeByPath(target, current.leftChild, res);
                if (current.rightSibling != null)
                    res = findNodeByPath(target, current.rightSibling, res);
            } else {
                res = current;
            }
        }
        return res;
    }

    public FileNode findNodeByName(String target, FileNode current, FileNode res) {
        if (res == null) {
            if (current != null && !current.filename.equals(target)) {
                if (current.leftChild != null)
                    res = findNodeByName(target, current.leftChild, res);
                if (current.rightSibling != null)
                    res = findNodeByName(target, current.rightSibling, res);
            } else {
                res = current;
            }
        }
        return res;
    }

    public void walk() {
        System.out.print(pathWithFilename + "\t\t\tis " + status + "\n");
        if (leftChild != null)
            leftChild.walk();
        if (rightSibling != null)
            rightSibling.walk();
    }

}
