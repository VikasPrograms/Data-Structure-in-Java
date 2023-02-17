

//----------------------------------------------------------------------
//
// Description   :  DOUBLY LINEAR LINKED LIST USING Java
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
// Function Name    :   class Doubly
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Description      :   This Class represents Doubly linear linked list
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

class Doubly
{
    private Node Head;
    private int Count;
  
//----------------------------------------------------------------------
//
// Class Name       :   Doubly
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   NONE
// Description      :   This Is Constructor Of Class Doubly
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

    public Doubly()     // Constructor
    {
        Head = null;
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

    protected void finalize()   // Memory Free
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

    public void Display()       // Linked List Display
    {
        Node temp = Head;

        while(temp != null)
        {
            System.out.print("| "+temp.Data+" | <=> ");
            temp = temp.Next;
        }
        System.out.println(" NULL");
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

    public int CountNodes()     // Nodes Count
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

    public void InsertFirst(int No)     // Insert First Function
    {
        Node newn = new Node(No);

        if(this.Head == null)
        {
            this.Head = newn;
        }
        else
        {
            newn.Next = this.Head;
            Head.Prev = newn;
            newn.Prev = null;
            this.Head = newn;
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

        if(this.Head == null)
        {
            this.Head = newn;
        }
        else
        {
            Node temp = Head;
            while(temp.Next != null)
            {
                temp = temp.Next;
            }
            temp.Next = newn;
            newn.Prev = temp;
            newn.Next = null;
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
            System.out.println("Invalid Position");
        }

        if(iPos == 1)
        {
            InsertFirst(No);
        }
        else if( iPos == Count+1)
        {
            InsertLast(No);
        }
        else
        {
            Node temp = Head;
            int iCnt = 0;
            
            for(iCnt = 1; iCnt < iPos - 1;iCnt++)
            {
                temp = temp.Next;
            }
            newn.Next = temp.Next;
            temp.Next = newn;
            newn.Prev = temp;
            newn.Next.Prev = newn;
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
        if(this.Head == null)
        {
            return;
        }
        else if(Head.Next == null)
        {
            this.Head = null;
        }
        else
        {
            Head = Head.Next;
            Head.Prev = null;
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
        if(this.Head == null)
        {
            return;
        }
        else if(Head.Next == null)
        {
            this.Head = null;
        }
        else
        {
            Node temp = Head;
            while(temp.Next.Next != null)
            {
                temp = temp.Next;
            }
            temp.Next = null;
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
            System.out.println("Invalid Position");
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
            int iCnt = 0;

            for(iCnt = 1; iCnt < iPos-1; iCnt++)
            {
                temp = temp.Next;
            }
            temp.Next = temp.Next.Next;
            temp.Next.Next.Prev = temp;
        }
        this.Count--;
    }
}

//----------------------------------------------------------------------
//
//
// Function Name   :   class DoublyLL
//                     Entry Point Function
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Brif Description :  Function Calls For Above Created Functions With Dynamic Input
//
//
//----------------------------------------------------------------------

class DoublyLL
{
    public static void main(String Arr[])
    {
        Doubly obj = new Doubly();
        int ret = 0;
        
        System.out.println("\n>>--------------->> Insert First Function <<--------------<<\n\n");
        obj.InsertFirst(40);
        obj.Display();
        obj.InsertFirst(30);
        obj.Display();
        obj.InsertFirst(20);
        obj.Display();
        obj.InsertFirst(10);
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert First are : "+ret);
        
        System.out.println("\n>>--------------->> Insert Last Function <<--------------<<\n\n");
        obj.InsertLast(50);
        obj.Display();
        obj.InsertLast(60);
        obj.Display();
        obj.InsertLast(70);
        obj.Display();
        obj.InsertLast(80);
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert Last are : "+ret);
        
        System.out.println("\n>>--------------->> Insert At Position Function <<--------------<<\n\n");
        obj.InsertAtPos(55,5);
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert At Position are : "+ret);
        
        System.out.println("\n>>--------------->> Delete First Function <<--------------<<\n\n");
        obj.DeleteFirst();
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete First are : "+ret);
        
        System.out.println("\n>>--------------->> Delete Last Function <<--------------<<\n\n");
        obj.DeleteLast();
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete Last are : "+ret);
        
        System.out.println("\n>>--------------->> Delete At Position Function <<--------------<<\n\n");
        obj.DeleteAtPos(4);
        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete At Position are : "+ret);
    }
}