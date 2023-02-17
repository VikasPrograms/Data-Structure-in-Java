
//----------------------------------------------------------------------
//
// Description   :  Doubly Circular Linked List Using Java
// Input         :  Int
// Output        :  Int
// Author        :  Vikas Bade
// Date          :  26 Jully 2022
//
//----------------------------------------------------------------------


//----------------------------------------------------------------------
// Import java.util
//----------------------------------------------------------------------

import java.util.*;

//----------------------------------------------------------------------
//
// Function Name    :   class Node
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Description      :   defined variables
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

class Node
{
    public int Data;
    public Node Next;
    public Node Prev;
    
    public Node(int No)
    {
        this.Data = No;
        this.Next = null;
        this.Prev = null;
    }
}

//----------------------------------------------------------------------
//
// Function Name    :   class DoublyCircular
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Description      :   This Class represents Doubly Circular linked list
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

class DoublyCircular
{
    private Node Head;
    private Node Tail;
    private int Count;
  
//----------------------------------------------------------------------
//
// Class Name       :   DoublyCircular
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   NONE
// Description      :   This Is Constructor Of Class DoublyCircular
//
// Returns          :   NONE
//
//----------------------------------------------------------------------
  

    public DoublyCircular()
    {
        Head = null;
        Tail = null;
        Count = 0;
    }
  
//----------------------------------------------------------------------
//
// Class Name       :   finalize
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   NONE
// Description      :   Useful for cleanup activities / free Memory
//
// Returns          :   NONE
//
//----------------------------------------------------------------------
  
    protected void finalize()
    {}
  
//----------------------------------------------------------------------
//
// Function Name    :   Display()
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   None
// Description      :   Display Function Display The Nodes In LinkedList 
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

    public void Display()
    {
        System.out.println("\nElements of Doubly Circular Linked List are : \n");

        do
        {
            System.out.print("| "+Head.Data+" | <=> ");
            Head = Head.Next;
        }while(Head != Tail.Next);      
    }
 
//----------------------------------------------------------------------
//
// Function Name    :   Count()
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   None
// Description      :   Count Function Count Number Of Nodes In LinkedList 
//
// Returns          :   Return Number Of Nodes In LinkedList
//
//----------------------------------------------------------------------

    public int CountNodes()
    {
        return this.Count;
    }

//----------------------------------------------------------------------
//
// Function Name    :   InsertFirst()
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   int 
// Description      :   InsertFirst Function Add New Node At Beginning Of LinkedList 
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

    public void InsertFirst(int No)
    {
        Node newn = new Node(No);

        if((this.Head == null) && (this.Tail == null))
        {
            Head = Tail = newn;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        else
        {
            newn.Next = Head;
            Head = newn;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count++;
    }

//----------------------------------------------------------------------
//
// Function Name    :   InsertLast()
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   int 
// Description      :   InsertLast Function Add New Node At End Of LinkedList 
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

    public void InsertLast(int No)
    {
        Node newn = new Node(No);

        if((this.Head == null)  && (this.Tail == null))
        {
            Head = Tail = newn;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        else
        {
            Tail.Next = newn;
            newn.Prev = Tail;
            Tail = newn;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count++;
    }
  
//----------------------------------------------------------------------
//
// Function Name    :   InsertAtPos()
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   int, int
// Description      :   InsertAtPosition Function Add New Node At Given Position In The LinkedList 
//
// Returns          :   NONE
//
//----------------------------------------------------------------------
    
    public void InsertAtPos(int No, int iPos)
    {
        Node newn = new Node(No);

        if((iPos < 1) || (iPos > Count+1))
        {
            System.out.println("Invalid Position\n");
        }

        if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if(iPos == Count+1)
        {
            InsertLast(No);
        }
        else
        {
            Node temp = Head;

            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            newn.Next = temp.Next;
            temp.Next = newn;
            newn.Prev = temp;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count++;
    }

//----------------------------------------------------------------------
//
// Function Name    :   DeleteFirst()
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   ----
// Description      :   DeleteFirst Function Remove The Node From Beginning Of The LinkedList 
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

    public void DeleteFirst()
    {
        if((this.Head == null) && (this.Tail == null))
        {
            return;
        }
        else if(this.Head == this.Tail)
        {
            this.Head = null;
            this.Tail = null;
        }
        else
        {
            Head = Head.Next;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count--;
    }
  
//----------------------------------------------------------------------
//
//
// Function Name    :   DeleteLast()
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   ----
// Description      :   DeleteLast Function Remove The Node At End Of The LinkedList 
//
// Returns          :   NONE
//
//
//----------------------------------------------------------------------

    public void DeleteLast()
    {
        if((this.Head == null) && (this.Tail == null))
        {
            return;
        }
        else if(this.Head == this.Tail)
        {
            this.Head = null;
            this.Tail = null;
        }
        else
        {
            Node temp = Head;
            while(temp.Next != Tail)
            {
                temp = temp.Next;
            }
            Tail = temp;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count--;
    }
  
//----------------------------------------------------------------------
//
//
// Function Name    :   DeleteAtPos()
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   int
// Description      :   DeleteAtPosition Function Remove Existing Node At Any Position In The LinkedList 
//
// Returns          :   NONE
//
//
//----------------------------------------------------------------------

    public void DeleteAtPos(int iPos)
    {
        if((iPos < 1) || (iPos > Count+1))
        {
            System.out.println("Invalid Position\n");
        }

        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == Count)
        {
            DeleteLast();
        }
        else
        {
            Node temp = Head;
            for(int iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            temp.Next = temp.Next.Next;
            temp.Next.Prev = temp;
            Tail.Next = Head;
            Head.Prev = Tail;
        }
        this.Count--;
    }
}

//----------------------------------------------------------------------
//
//
// Function Name   :   class DoublyCLL
//                     Entry Point Function
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Brif Description :  Function Calls For Above Created Functions With Dynamic Input
//
//
//----------------------------------------------------------------------

class DoublyCLL
{
    public static void main(String Arr[])
    {
        DoublyCircular obj = new DoublyCircular();
        int ret = 0;
        
        System.out.println("\n>>-------------->> Insert First Function <<-------------<<\n");
        obj.InsertFirst(40);
        obj.Display();
        obj.InsertFirst(30);
        obj.Display();
        obj.InsertFirst(20);
        obj.Display();
        obj.InsertFirst(10);
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Insert First are : "+ret);
        
        System.out.println("\n>>-------------->> Insert Last Function <<-------------<<\n");
        obj.InsertLast(50);
        obj.Display();
        obj.InsertLast(60);
        obj.Display();
        obj.InsertLast(70);
        obj.Display();
        obj.InsertLast(80);
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Insert Last are : "+ret);
        
        System.out.println("\n>>-------------->> Insert At Position Function <<-------------<<\n");
        obj.InsertAtPos(55, 6);
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Insert At Position are : "+ret);
        
        System.out.println("\n>>-------------->> Delete First Function <<-------------<<\n");
        obj.DeleteFirst();
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Delete First are : "+ret);
        
        System.out.println("\n>>-------------->> Delete Last Function <<-------------<<\n");
        obj.DeleteLast();
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Delete Last are : "+ret);
        
        System.out.println("\n>>-------------->> Delete At Position Function <<-------------<<\n");
        obj.DeleteAtPos(5);
        obj.Display();

        ret = obj.CountNodes();
        System.out.println("\nNumber of Nodes After Delete At Position are : "+ret);
    }
}