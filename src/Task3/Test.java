package Task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {

        // SETUP
        final String ROOT = "/Users/_norm";
        String filename = "A";
        LCRS_Tree t = new LCRS_Tree(new FileNode(ROOT,filename));

        // TEST STRINGS
        // with path
        String a2 = ROOT + "/A";
        String b2 = ROOT + "/A/B";
        String c2 = ROOT + "/A/C";
        String d2 = ROOT + "/A/D";
        String e2 = ROOT + "/A/C/E";
        String f2 = ROOT + "/A/C/F";
        String g2 = ROOT + "/A/.DS_Store";
        String h2 = ROOT + "/A/C/.DS_Store";
        String i2 = ROOT + "/A/C/TEST4.py";
        String aw2 = ROOT + "/A/C/G"; // not existing
        String bw2 = ROOT + "/A/C/H"; // not existing
        String cw2 = ROOT + "/A/C/I"; // not existing
        String dw2 = ROOT + "/A/C/J"; // not existing

        // only file/dir name
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";
        String g = ".DS_Store";
        String h = "TEST4.py";
        String aw = "G"; // not existing
        String bw = "H"; // not existing
        String cw = "I"; // not existing
        String dw = "J"; // not existing
        String zzz = "ZZZ.py"; // to be added (not existing but will exist)


        ArrayList<String> pathlist = new ArrayList<>();
        Collections.addAll(pathlist, a2, b2, c2, d2, e2, f2, g2, h2, i2, aw2, bw2, cw2, dw2);

        ArrayList<String> namelist = new ArrayList<>();
        Collections.addAll(namelist, a, b, c, d, e, f, g, h, aw, bw, cw, dw, zzz);

        // START
        System.out.println("\nCREATE TREE:\n");

        t.createTree();
        t.walkTree();

        System.out.println("\n-----------------------------------------\n");

        // TESTING NODE EXISTS
        for (String file : namelist) {
            System.out.println("NODE EXISTS: " + file + " - \t\t\t" + t.nodeExists(file));
        }

        System.out.println("\n-----------------------------------------\n");

        // TESTING FIND NODE BY PATH
        for (String path : pathlist) {
            FileNode res = t.findNodeByPath(path);
            if (res != null)
                System.out.println("FIND NODE BY PATH: " + path + " - \t\t\t" + res.filename);
            else
                System.out.println("FIND NODE BY PATH: " + path + " - \t\t\t" + "not found");
        }

        System.out.println("\n-----------------------------------------\n");

        // TESTING FIND NODE BY NAME
        for (String fname : namelist) {
            FileNode res = t.findNodeByName(fname);
            if (res != null)
                System.out.println("FIND NODE BY NAME: " + fname + " - \t\t\t" + res.pathWithFilename);
            else
                System.out.println("FIND NODE BY NAME: " + fname + " - \t\t\t" + "not found");
        }

        System.out.println("\n-----------------------------------------\n");
        System.out.println("ADDING NODE: " + zzz + " TO EXISTING NODE: " + e2 + "\n");
        // TESTING ADDING NODE TO EXISTING NODE
        t.addNodeToExistingNode(e2,zzz);
        t.walkTree();
    }
}
