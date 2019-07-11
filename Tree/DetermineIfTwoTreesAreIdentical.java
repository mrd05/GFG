package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetermineIfTwoTreesAreIdentical {

	static class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	static class Driverclass
	{
	    // driver function to test the above functions
	    public static void main(String args[])
	    {
	        // Input the number of test cases you want to run
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while (t > 0)
	        {
	            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
	            int n = sc.nextInt();
	            Node root = null;
	            while (n > 0)
	            {
	                int n1 = sc.nextInt();
	                int n2 = sc.nextInt();
	                char lr = sc.next().charAt(0);
	                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
	                Node parent = m.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    m.put(n1, parent);
	                    if (root == null)
	                        root = parent;
	                }
	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                m.put(n2, child);
	                n--;
	            }
				
				//sec tree
				
				 HashMap<Integer, Node> mm = new HashMap<Integer, Node> ();
	            int nn = sc.nextInt();
	            Node roott = null;
	            while (nn > 0)
	            {
	                int n1 = sc.nextInt();
	                int n2 = sc.nextInt();
	                char lr = sc.next().charAt(0);
	                
	                Node parent = mm.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    mm.put(n1, parent);
	                    if (roott == null)
	                        roott = parent;
	                }
	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                mm.put(n2, child);
	                nn--;
	            }
	            Tree g = new Tree();
	            //System.out.println(g.isIdentical(root,roott));
				
				boolean b = g.isIdentical(root,roott);
				if(b==true)
					System.out.println(1);
				else
					System.out.println(0);
	            t--;
				//System.out.println();
	        }
	    }
	}

	
	/*This is a function problem.You only need to complete the function given below*/
	/* A Binary Tree node
	class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	*/
	static class Tree
	{
		/* Should return true if trees with roots as root1 and 
	   root2 are identical else false */
	   
		//using recursion
		/*boolean isIdentical(Node root1, Node root2)
		{
		    if(root1==null && root2==null)
		        return true;
		    if(root1==null || root2==null)
		        return false;
		    
		    if(root1.data!=root2.data)
		        return false;
		    
		    return isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
		}*/
		
		//using level order traversal of both together
		boolean isIdentical(Node root1, Node root2)
		{
		    if(root1==null && root2==null)
		        return true;
		    if(root1==null || root2==null)
		        return false;
		    
		    Queue<Node> q1=new LinkedList<>();
		    Queue<Node> q2=new LinkedList<>();
		    
		    q1.add(root1);
		    q2.add(root2);
		    while(!q1.isEmpty() && !q2.isEmpty())
		    {
		        Node n1=q1.poll();
		        Node n2=q2.poll();
		        
		        if(n1.data!=n2.data)
		            return false;
		        
		        if(n1.left!=null && n2.left!=null)
		        {
		        	q1.add(n1.left);
		        	q2.add(n2.left);
		        }
		        else if(n1.left!=null || n2.left!=null)
		        	return false;
		        
		        if(n1.right!=null && n2.right!=null)
		        {
		        	q1.add(n1.right);
		        	q2.add(n2.right);
		        }
		        else if(n1.right!=null || n2.right!=null)
		        	return false;

		    }
		    if(!q1.isEmpty() || !q2.isEmpty())
		        return false;
		    return true;
		}
		
	}

}
