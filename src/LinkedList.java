public class LinkedList
{
    private SinglyLinkedListNode head;
    private int length;

    public SinglyLinkedListNode getHead()
    {
        return head;
    }

    public void setHead(SinglyLinkedListNode head)
    {
        this.head = head;
    }

    public void printList()
    {
        SinglyLinkedListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    public int getLength()
    {
        int count = 0;
        SinglyLinkedListNode temp = head;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void insertNodeAtFirst(SinglyLinkedListNode node)
    {
        if (head == null)
        {
            head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    public void insertNodeAtLast(SinglyLinkedListNode node)
    {
        if (head == null)
        {
            head = node;
            return;
        }
        SinglyLinkedListNode temp = head;
        while (temp.getNext() != null)
        {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void insertNodeAtPosition(int position, SinglyLinkedListNode node)
    {
        if (position < 0 || getLength() + 1 < position)
        {
            throw new IllegalArgumentException("Illegal position");
        }
        if (position == 1)
        {
            node.setNext(head);
            head = node;
        }
        else
        {
            int count = 1;
            SinglyLinkedListNode previous = head;
            while (count < position - 1)
            {
                previous = previous.getNext();
                count++;
            }
            node.setNext(previous.getNext());
            previous.setNext(node);
        }
    }

    public void deleteFirstNode()
    {
        if (head == null)
        {
            throw new IllegalArgumentException("No node available to Delete.");
        }
        head = head.getNext();
    }

    public void deleteLastNode()
    {
        if (head == null)
        {
            throw new IllegalArgumentException("No node available to Delete.");
        }
        SinglyLinkedListNode temp = head;
        while (temp.getNext().getNext() != null)
        {
            temp = temp.getNext();
        }
        temp.setNext(null);
    }

    public void deleteNodeAtPosition(int position)
    {
        if (position < 0 || getLength() + 1 < position)
        {
            throw new IllegalArgumentException("Illegal position");
        }
        if (position == 1)
        {
            head = null;
        }
        else
        {
            int count = 1;
            SinglyLinkedListNode previous = head;
            while (count < position - 1)
            {
                previous = previous.getNext();
                count++;
            }
            previous.setNext(previous.getNext().getNext());
        }
    }

    public boolean isElementPresent(int a)
    {
        boolean isPresent = false;
        SinglyLinkedListNode temp = head;
        while (temp != null && !isPresent)
        {
            isPresent = temp.getData() == a;
            temp = temp.getNext();
        }
        return isPresent;
    }

    public void reverseLinkedList()
    {
        if(head==null)
        {
            return;
        }
        SinglyLinkedListNode previous = null;
        SinglyLinkedListNode current = head;
        while(head!=null)
        {
            head =head.getNext();
            current.setNext(previous);
            previous=current;
            current=head;
        }
        head=previous;
    }

    public SinglyLinkedListNode findMiddle()
    {
        if(head==null)
        {
            return null;
        }
        SinglyLinkedListNode slwPtr = head;
        SinglyLinkedListNode fstPtr = head;
        while(fstPtr!=null && fstPtr.getNext()!=null)
        {
            slwPtr = slwPtr.getNext();
            fstPtr = fstPtr.getNext().getNext();
        }
        return slwPtr;
    }

    public SinglyLinkedListNode getNthNodeFromEnd(int position)
    {
        if(head==null)
        {
            return null;
        }
        int length = 0;
        SinglyLinkedListNode slwPtr = head;
        SinglyLinkedListNode fstPtr = head;
        while(fstPtr!=null && fstPtr.getNext()!=null)
        {
            length++;
            slwPtr = slwPtr.getNext();
            fstPtr = fstPtr.getNext().getNext();
        }
        int distToConver = 0;
        if(fstPtr == null)
        {
            distToConver  = length-position;
        }
        else
        {
            distToConver  = length+1-position;
        }
        for(int i=0;i<distToConver;i++)
        {
            slwPtr = slwPtr.getNext();
        }
        return slwPtr;
    }

    // For a sorted linked list
    public void removeDuplicates()
    {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode temp = current;
        while (temp.getNext() != null)
        {
            if(temp.getData() == temp.getNext().getData())
            {
                temp = temp.getNext();
            }
            else
            {
                current.setNext(temp.getNext());
                current = current.getNext();
                temp = temp.getNext();
            }
        }
    }

    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();
        SinglyLinkedListNode head = new SinglyLinkedListNode(1);
        SinglyLinkedListNode second = new SinglyLinkedListNode(2);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3);
        linkedList.head = head;
        head.setNext(second);
        second.setNext(third);
        linkedList.printList();
        System.out.println("LinkedList count: " + linkedList.getLength());
        linkedList.insertNodeAtFirst(new SinglyLinkedListNode(0));
        linkedList.insertNodeAtLast(new SinglyLinkedListNode(4));
        linkedList.insertNodeAtPosition(6, new SinglyLinkedListNode(10));
        linkedList.printList();
        System.out.println("LinkedList count: " + linkedList.getLength());
        System.out.println("Delete firstNode");
        linkedList.deleteFirstNode();
        linkedList.printList();
        System.out.println("Delete lastNode");
        linkedList.deleteLastNode();
        linkedList.printList();
        System.out.println("Delete 3rd node");
        linkedList.deleteNodeAtPosition(3);
        linkedList.printList();
        System.out.println("Is element 3 present? "+linkedList.isElementPresent(3));
        linkedList.reverseLinkedList();
        linkedList.printList();
        System.out.println("Middle element of the LinkedList: "+linkedList.findMiddle().getData());
        linkedList.insertNodeAtPosition(2, new SinglyLinkedListNode(3));
        linkedList.insertNodeAtFirst(new SinglyLinkedListNode(5));
        linkedList.insertNodeAtFirst(new SinglyLinkedListNode(6));
        linkedList.printList();
        System.out.println("3rd node from the end of the LinkedList: "+linkedList.getNthNodeFromEnd(3).getData());
        linkedList.insertNodeAtFirst(new SinglyLinkedListNode(6));
        linkedList.insertNodeAtFirst(new SinglyLinkedListNode(6));
        linkedList.printList();
        linkedList.removeDuplicates();
        linkedList.printList();
    }
}
