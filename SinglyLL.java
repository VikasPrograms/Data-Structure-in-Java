// Singly Linear Link List in java

//----------------------------------------------------------------------
//
// Description   :  SINGLY LINEAR LINKED LIST USING Java
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

    public Node(int No)
    {
        this.Data = No;
        this.Next = null;
    }
}

//----------------------------------------------------------------------
//
// Function Name    :   class Singly
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Description      :   This Class represents Singly linear linked list
//
// Returns          :   NONE
//
//----------------------------------------------------------------------

class Singly
{
    private Node Head;
    private int Count;
  
//----------------------------------------------------------------------
//
// Class Name       :   Singly
// Date             :   26 Jully 2022
// Function Author  :   Vikas Bade
// Parameters       :   NONE
// Description      :   This Is Constructor Of Class Singly
//
// Returns          :   NONE
//
//----------------------------------------------------------------------
  
    public Singly()       // Constructor
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
  
    protected void finalize()
    {
        // Memory free
    }
  
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
            System.out.print("| "+temp.Data+" | -> ");
            temp = temp.Next;       // in C temp = temp -> Next;
        }
        System.out.println("NULL");
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

        // Node newn = new Node();
        // newn.Data = No;
        // newn.Next = null;

        if(this.Head == null)
        {
            this.Head = newn;
        }
        else
        {
            newn.Next = this.Head;
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
        if((iPos < 1) || (iPos > Count+1))
        {
            System.out.println("Invalid postion");
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
            Node newn = new Node(No);
            Node temp = Head;

            for(int i =1; i< iPos-1;i++)
            {
                temp = temp.Next;
            }

            newn.Next = temp.Next;
            temp.Next = newn;  

            Count++;     
        }
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
        // if(this.Head == null)
        // {
        //     return;
        // }

        if(this.Count == 0)
        {
            return;
        }
        else if(this.Count == 1)
        {
            this.Head = null;
        }
        else
        {
            Head = Head.Next;
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

        if(this.Count == 0)
        {
            return;
        }
        else if(this.Count == 1)
        {
            this.Head = null;
        }
        else
        {
            Node temp = this.Head;
            
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
            System.out.println("Invalid postion");
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

            for(int i = 1; i < iPos-1; i++)
            {
                temp = temp.Next;
            }

            temp.Next = temp.Next.Next;

            Count--;
        }
    }
}

//----------------------------------------------------------------------
//
//
// Function Name   :   class SinglyLL
//                     Entry Point Function
// Function Date    :   26 Jully 2022
// Function Author  :   Vikas Bade
// Brif Description :  Function Calls For Above Created Functions With Dynamic Input
//
//
//----------------------------------------------------------------------

class SinglyLL
{
    public static void main(String Arr[])
    {
        Singly obj = new Singly();
        int ret = 0;

        obj.InsertFirst(40);
        obj.InsertFirst(30);
        obj.InsertFirst(20);
        obj.InsertFirst(10);

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert First are : "+ret);

        obj.InsertLast(50);
        obj.InsertLast(60);
        obj.InsertLast(70);
        obj.InsertLast(80);

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert Last are : "+ret);

        obj.InsertAtPos(55, 6);

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Insert At Position are : "+ret);

        obj.DeleteFirst();

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete First are : "+ret);

        obj.DeleteLast();

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete Last are : "+ret);

        obj.DeleteAtPos(5);

        obj.Display();
        ret = obj.CountNodes();
        System.out.println("Number of nodes After Delete At Position are : "+ret);
    }
}