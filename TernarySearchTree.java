
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class Tree {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

   public void insert(int val) 
    {
     if(root==null)
     {
       root=new Node(val);
     }
      else
      {
        root=insert(val,root);
      }
    }
  private Node insert(int val, Node rootpointer)
  {
    if(val<rootpointer.val)
    {
    if(rootpointer.left==null)
    {
      rootpointer.left=new Node(val);
    }
      else
      {
      insert(val,rootpointer.left);  
      }
      }
     if(val>rootpointer.val)
    {
    if(rootpointer.right==null)
    {
      rootpointer.right=new Node(val);
    }
      else
      {
      insert(val,rootpointer.right);  
      }
      }
     if(val==rootpointer.val)
    {
    if(rootpointer.mid==null)
    {
      rootpointer.mid=new Node(val);
    }
      else
      {
      insert(val,rootpointer.mid);  
      }
      }
    return rootpointer;
  }
        
 
   public void delete(int val) 
    {
if(root!=null)
{
  root=delete(val, root);
}
      }
  public Node delete(int val, Node rootpointer)
  {    
  if(val<rootpointer.val)
  { 
    rootpointer.left=delete(val,rootpointer.left);
  }
  if(val>rootpointer.val)
  {
   
    rootpointer.right=delete(val,rootpointer.right);
  }
    if(val==rootpointer.val)
    {
      if(rootpointer.mid!=null)
      {
         
      rootpointer.mid=delete(val,rootpointer.mid);
      }
      else if(rootpointer.right!=null)
      {
        int minvalue=MinTreeVal(rootpointer.right).val;
            rootpointer.val=minvalue;
          rootpointer.right=delete(minvalue,rootpointer.right);
            }
        else
            rootpointer=rootpointer.left;
        
      }
    
  return rootpointer;
  }

private Node MinTreeVal(Node Rootpointer)
    {
    if(Rootpointer!=null)
        {
    while(Rootpointer.left!=null)
        {
        return MinTreeVal(Rootpointer.left);
    }
    }
    return Rootpointer;
}