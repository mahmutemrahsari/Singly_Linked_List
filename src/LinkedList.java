public class LinkedList {

    private static class Node{
        private final int  data;
        private Node next = null;

        public Node(int data){
            this.data = data;
        }
    }

    private Node head = null;

    // Add new node in the end of the List
    public void addNodeToTheEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            // Very Important!
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            // Make iteration with while loop first, find the last node and add the new Node out of While loop!
            last.next=newNode;
        }
    }

    // Add new node in the start (new head)
    public void addNodeToTheStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node tmp = head;
            head = newNode;
            head.next = tmp;
        }
    }

    // Insert new node to the given index!
    public void insertNodeToTheGivenIndex(int index, int data){
        int size = size(); // for performance improvement!

        //Index validation
        checkIndex(index);

        if(index==0){
            addNodeToTheStart(data);
        }else if(index==size){
            addNodeToTheEnd(data);
        }
        //Important
        Node newNode = new Node(data);
        Node current = head;
        Node previous = null;
        int i = 0;
        while(i<index){
            previous = current; //Update previous Node in the loop!
            current = current.next;
            i++;
        }
        newNode.next = current;
        assert previous != null;
        previous.next = newNode;
    }
    //Update Node in the given index without adding new node to the list!
    public void updateNode(int index, int data){
        //index validation
        checkIndex(index);
        if(head.next==null){
            head = new Node(data);
            return;
        }

        Node current = head;
        Node prev = null;
        Node newNode = new Node(data);
        int i = 0;
        while (i < index){
            prev = current;
            current = current.next;
            i++;
        }
        newNode.next=current.next;
        assert prev != null;
        prev.next = newNode;

    }

    // Delete the last node!
    public void deleteLastNode(){
        if(head==null){
            System.out.println("There is nothing to DELETE! Empty List!");
        }else if(head.next==null){
            head = null;
        }else{
            //Important !
            Node last = head;
            while(last.next.next!=null){
                last = last.next;
            }
            last.next = null;
        }
    }
    // Delete the first node! (aka. head node)
    public void deleteFirstNode(){
        if(head==null){
            System.out.println("There is nothing to DELETE! Empty List!");
        }if(head.next==null){
            head = null;
        }else{
            head = head.next;
        }
    }

    public void deleteNodeFromGivenIndex(int index){
        int size = size();
        //Index validation
        checkIndex(index);

        if(index ==0){
            deleteFirstNode();
            return;
        }

        if(index == size){
            deleteLastNode();
            return;
        }

        Node current = head;
        Node previous = null;

        int i = 0;
        while(i<index){
            previous = current;
            current = current.next;
            i++;
        }
        assert previous != null;
        previous.next = current.next;
       //current = previous;
    }

    public int size(){
        int size =0;
        Node current = head;

        while(current != null){
            size++;
            current = current.next; // Iteration of the current or head
        }
        return size;
    }

    //Gets the node from given index!
    public Node getNodeFromGivenIndex(int index){
        //Index validation
        checkIndex(index);

        int i = 0;
        Node current = head;
        while (i<index){
            current = current.next;
            i++;
        }
        return current;
    }

    // Gets data from given index.
    public int getDataFromGivenIndex(int index){
        //Index validation
        checkIndex(index);
        return getNodeFromGivenIndex(index).data;
    }

    //Index validation func.
    public void checkIndex(int index){
        int size = size();
        if(index<0||index>size){
            System.out.println("Invalid Index! Insert a valid index and try again!");
        }
    }

    public void display(){
        if(head == null){
            System.out.println("Empty List!");
        }else{
            // Make a new Node which is equal the head then traverse the list!
            Node current = head;
            while(current !=null){
                System.out.println(current.data);
                current = current.next;
            }
        }
    }


    //Test
    public static void main(String[] args) {
        LinkedList sll = new LinkedList();

      sll.addNodeToTheEnd(10);
      sll.addNodeToTheEnd(20);
      sll.addNodeToTheEnd(30);
      sll.addNodeToTheEnd(40);
      sll.addNodeToTheEnd(50);
      sll.addNodeToTheStart(60);
      sll.addNodeToTheStart(70);
        System.out.println("SSL Data respectively: ");
        sll.display();
        System.out.println("Size of SLL: " + sll.size());
        System.out.println("--------------------------------");
        sll.deleteLastNode();
        System.out.println("SSL Data after deleted the last node respectively: ");
        sll.display();
        System.out.println("Size after deleted last node SLL: " + sll.size());
        System.out.println("--------------------------------");
        sll.deleteFirstNode();
        System.out.println("SSL Data after deleted first node respectively: ");
        sll.display();
        System.out.println("Size after deleted first node SLL: " + sll.size());
        sll.insertNodeToTheGivenIndex(3,300);
        sll.display();
        System.out.println("Size after adding node in the given index SLL: " + sll.size());
        System.out.println("--------------------------------");
        sll.deleteNodeFromGivenIndex(5);
        sll.display();
        System.out.println("Size after deleting the node from given index: " + sll.size());
        System.out.println("--------------------------------");
        int i = 3; int data=200;
        System.out.println("Data from given index:"+i+ " data:"  + sll.getDataFromGivenIndex(i));
        System.out.println("--------------------------------");
        System.out.println("Update node in the given index: " + i + " with the data: " + data);
        sll.updateNode( i,data);
        sll.display();
        System.out.println("--------------------------------");
    }
}
