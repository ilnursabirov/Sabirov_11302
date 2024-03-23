class Node {
    int index;
    int value;
    Node next;

    Node(int index, int value) {
        this.index = index;
        this.value = value;
        this.next = null;
    }
}

public class VectorCode {
    private int length;
    Node head;

    public VectorCode(int[] arr) {
        this.length = arr.length;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                if(head == null) {
                    head = new Node(i, arr[i]);
                } else {
                    Node cur = head;
                    while(cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = new Node(i, arr[i]);
                }
            }
        }
    }

    public int[] decode() {
        int[] arr = new int[length];
        Node cur = head;
        while (cur != null) {
            arr[cur.index] = cur.value;
            cur = cur.next;
        }
        return arr;
    }


    public void insert(int k, int pos) {
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.index != pos) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            cur.value = k;
        } else if (head == null || head.index > pos) {
            Node newNode = new Node(pos, k);
            newNode.next = head;
            head = newNode;
        } else {
            Node newNode = new Node(pos, k);
            prev.next = newNode;
            newNode.next = cur;
        }
    }

    public void delete(int pos) {
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.index != pos) {
            prev = cur;
            cur = cur.next;
        }
        if (cur != null) {
            if (prev == null) {
                head = head.next;
            } else {
                prev.next = cur.next;
            }
        }
    }

    public int scalarProduct(VectorCode v) {
        Node currA = head;
        Node currB = v.head;
        int result = 0;
        while (currA != null && currB != null) {
            if (currA.index == currB.index) {
                result += currA.value * currB.value;
                currA = currA.next;
                currB = currB.next;
            } else if (currA.index < currB.index) {
                currA = currA.next;
            } else {
                currB = currB.next;
            }
        }
        return result;
    }

    public VectorCode sum(VectorCode v) {
        VectorCode sumVector = new VectorCode(new int[Math.max(length, v.length)]);
        Node currA = head;
        Node currB = v.head;
        while (currA != null || currB != null) {
            if (currA == null) {
                sumVector.insert(currB.value, currB.index);
                currB = currB.next;
            } else if (currB == null) {
                sumVector.insert(currA.value, currA.index);
                currA = currA.next;
            } else if (currA.index == currB.index) {
                sumVector.insert(currA.value + currB.value, currA.index);
                currA = currA.next;
                currB = currB.next;
            } else if (currA.index < currB.index) {
                sumVector.insert(currA.value, currA.index);
                currA = currA.next;
            } else {
                sumVector.insert(currB.value, currB.index);
                currB = currB.next;
            }
        }
        return sumVector;
    }

    public VectorCode vectorSum() {
        VectorCode sumVector = new VectorCode(new int[length]);
        Node curr = head;
        int[] pSum = new int[length];
        int p = 0;
        while (curr != null) {
            p += curr.value;
            pSum[curr.index] = p;
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            sumVector.insert(pSum[curr.index], curr.index);
            curr = curr.next;
        }
        return sumVector;
    }

}


