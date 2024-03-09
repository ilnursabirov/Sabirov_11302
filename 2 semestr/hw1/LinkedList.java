/*

  00. Ввести линейный односвязный список (далее - список) целых чисел размера n.
  01. Найти максимум линейного списка размера n.
  02. Проверить наличие в линейном списке элемента равного x.
  03. Выполнить сортировку линейного списка целых чисел любым известным вам алгоритмом.
  04. Ввести линейный односвязный список целых чисел размера n в прямом порядке.
Вопрос: можно сначала создать список как есть, а потом создать нормальный на его основе?
Ответ: нет, нужно сразу создавать список в прямом порядке.
Подсказка: у списка может быть не только head, но и, например, end

  05. Удалить первые два элемента линейного списка.
  06. Удалить первое упоминание элемента x в списке
  07. Удалить из списка все элементы, равные x.
  08. В списке после первого элемента, равного x, вставить y.
  09. В списке перед первым элементом, равным x, вставить y.
  10. В списке после всех x вставить y. Гарантируется, что x не равно y.

*/

class LinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        Node current = head;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    public boolean contains(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void sort() {
        Node current = head;
        while (current != null) {
            Node t = current.next;
            while (t != null) {
                if (current.data > t.data) {
                    int swap = current.data;
                    current.data = t.data;
                    t.data = swap;
                }
                t = t.next;
            }
            current = current.next;
        }
    }

    public void removeFirstTwo() {
        if (head == null || head.next == null || head.next.next == null) {
            head = null;
        } else {
            head = head.next.next;
        }
    }

    public void removeFirstX(int x) {
        if (head == null) {
            return;
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void removeAllX(int x) {
        while (head != null && head.data == x) {
            head = head.next;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == x) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insertAfterFirstX(int x, int y) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                Node newNode = new Node(y);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void insertBeforeFirstX(int x, int y) {
        if (head == null || head.data == x) {
            Node newNode = new Node(y);
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == x) {
                Node newNode = new Node(y);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
    }

    public void insertAfterAllX(int x, int y) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                Node newNode = new Node(y);
                newNode.next = current.next;
                current.next = newNode;
                current = newNode;
            }
            current = current.next;
        }
    }
}