import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int eid;
    int imp;
    int [] subords;
    public Node(int eid, int imp, int [] subords) {
        this.eid = eid;
        this.imp = imp;
        this.subords = subords;
    }
}

public class EmployeeImportance {
    Node [] n = new Node[2];
    int target=5;
    public EmployeeImportance() {
        int [] a = new int[1];
        a[0] = 5;
        n[0] = new Node(1,2,a); 

        int [] b = {};
        n[1] = new Node(5, -3, b);
    }

    public int totalImportance() {
        int te = n.length;
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Node> mmap = new HashMap<>();
        int importance = 0;
        for (int i = 0; i < te; i++) {
            Node e = n[i];
            mmap.put(e.eid, e);
        }

        q.add(target);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int id = q.poll();
                System.out.println(id);
                Node temp = mmap.get(id);
                importance += temp.imp;
                if (temp.subords.length > 0) {
                    for (int k = 0; k < temp.subords.length; k++) {
                        int id1 = temp.subords[k];
                        q.add(id1);
                    }
                }
            }
        }
        return importance;
    }

    public static void main(String [] args) {
        EmployeeImportance ei = new EmployeeImportance();
        System.out.println(ei.totalImportance());
    }    
}
