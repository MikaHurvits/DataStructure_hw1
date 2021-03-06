
/**
*
* AVLTree
*
* An implementation of a AVL Tree with
* distinct integer keys and info
*
*/

public class AVLTree {
 
private IAVLNode root;     //creating a root field for the AVLTree type

//A-----------------------------------------------  tree constructor  ---------------------------------------

	public AVLTree() {
		AVLNode treeRoot = new AVLNode(); 
		this.root = treeRoot;
	}

//A------------------------------------------------  empty()  ------------------------------------------------
	
/**
* public boolean empty()
*
* returns true if and only if the tree is empty
*
*/
public boolean empty() {  
	  return (this.root == null);

}


//A----------------------------------------------  search (key)  -------------------------------------------------


/**
* public String search(int k)
*
* returns the info of an item with key k if it exists in the tree
* otherwise, returns null
*/
public String search(int k) {
	  IAVLNode x = this.root;
	  while (x != null) {
		  int xKey = x.getKey();
		  if (xKey == k) {
			  return x.getValue();
		  }
		  else if (xKey < k) {
			  x = x.getRight();
		  }
		  else {
			  x = x.getLeft();
		  }
	  }
	return null;
}

//M-------------------------------------  insert (k, i) + delete (k)  --------------------------------------------

/**
* public int insert(int k, String i)
*
* inserts an item with key k and info i to the AVL tree.
* the tree must remain valid (keep its invariants).
* returns the number of rebalancing operations, or 0 if no rebalancing operations were necessary.
* promotion/rotation - counted as one rebalnce operation, double-rotation is counted as 2.
* returns -1 if an item with key k already exists in the tree.
*/
public int insert(int k, String i) {
	  return 42;	// to be replaced by student code
}

/**
* public int delete(int k)
*
* deletes an item with key k from the binary tree, if it is there;
* the tree must remain valid (keep its invariants).
* returns the number of rebalancing operations, or 0 if no rebalancing operations were needed.
* demotion/rotation - counted as one rebalnce operation, double-rotation is counted as 2.
* returns -1 if an item with key k was not found in the tree.
*/
public int delete(int k)
{
	   return 42;	// to be replaced by student code
}

//M---------------------------------------  min() + max() -------------------------------------------   

/**
 * public String min()
 *
 * Returns the info of the item with the smallest key in the tree,
 * or null if the tree is empty
 */
public String min()
{
	  String res=null;
	  for (IAVLNode y=this.root;y!=null;y=y.getRight()) {
		  res = y.getValue();
	  }
	  	return res;
}

/**
 * public String max()
 *
 * Returns the info of the item with the largest key in the tree,
 * or null if the tree is empty
 */
public String max()
{
	  String res=null;
	  for (IAVLNode y=this.root;y!=null;y=y.getLeft()) {
		  res = y.getValue();
	  }
	  	return res;
}


//A--------------------------------------  keysToArray() + infoToArray()  ------------------------------------

//A--------------------------------------  keysToArray() + infoToArray()  ------------------------------------

/**
* public int[] keysToArray()
*
* Returns a sorted array which contains all keys in the tree,
* or an empty array if the tree is empty.
*/

//############################## naive solution with high complexity, needs modifications #####################
/*
	  public int[] keysToArray() {						//Envelope function
		  AVLNode rootNode = (AVLNode)this.root;		//casting root from IAVLNode to AVLNode - in order to use the getSize function
		  int[] res = new int[this.root.getSize()];
		  return keysToArrayRec(rootNode,0);
	  }
	  
	  
	  public int[] keysToArrayRec(AVLNode x,i) {  		//recursive function 
		  int xSize = x.getSize();
		  //int[] xArr = new int[xSize];
		  if (xSize == 0 ) { 							//its an EXT leaf
			  return null;
		  }		  
		  int[] leftArr = keysToArrayRec((AVLNode)x.getLeft());
		  int[] rightArr = keysToArrayRec((AVLNode)x.getRight());
		  System.arraycopy(leftArr, 0, xArr, 0, leftArr.length);
		  xArr[leftArr.length] = x.getKey();
		  System.arraycopy(rightArr, 0, xArr, leftArr.length + 1, rightArr.length);
		  return xArr;
	  }
*/
//----------------------------------------------------------------------------

/**
* public String[] infoToArray()
*
* Returns an array which contains all info in the tree,
* sorted by their respective keys,
* or an empty array if the tree is empty.
*/
public String[] infoToArray()
{
     String[] arr = new String[42]; // to be replaced by student code
     return arr;                    // to be replaced by student code
}

//M-----------------------------------------------  size () -----------------------------------------------

/**
 * public int size()
 *
 * Returns the number of nodes in the tree.
 *
 * precondition: none
 * postcondition: none
 */
public int size()
{
	AVLNode leftSon = (AVLNode)this.root.getLeft();
	AVLNode rightSon = (AVLNode)this.root.getRight();
	return leftSon.getSize() + 1 + rightSon.getSize();
}


//A---------------------------------------------  getRoot ()  --------------------------------------------


/**
* public int getRoot()
*
* Returns the root AVL node, or null if the tree is empty
*
* precondition: none
* postcondition: none
*/
public IAVLNode getRoot()
{
   if (this.empty()) {
	   return null;
   }
   return this.root;
}

//M---------------------------------------------  split (x) + join (x, t) ----------------------------------------------

    /**
   * public string split(int x)
   *
   * splits the tree into 2 trees according to the key x. 
   * Returns an array [t1, t2] with two AVL trees. keys(t1) < x < keys(t2).
	  * precondition: search(x) != null (i.e. you can also assume that the tree is not empty)
   * postcondition: none
   */   
  public AVLTree[] split(int x)
  {
	   return null; 
  }
  /**
   * public join(IAVLNode x, AVLTree t)
   *
   * joins t and x with the tree. 	
   * Returns the complexity of the operation (|tree.rank - t.rank| + 1).
	  * precondition: keys(x,t) < keys() or keys(x,t) > keys(). t/tree might be empty (rank = -1).
   * postcondition: none
   */   
  public int join(IAVLNode x, AVLTree t)
  {
	   return 0; 
  }
  
  
  
//------------------------------------- IAvLNode interface ---------------------------------------


	/**
	   * public interface IAVLNode
	   * ! Do not delete or modify this - otherwise all tests will fail !
	   */
	public interface IAVLNode{	
		public int getKey(); //returns node's key (for virtuval node return -1)
		public String getValue(); //returns node's value [info] (for virtuval node return null)
		public void setLeft(IAVLNode node); //sets left child
		public IAVLNode getLeft(); //returns left child (if there is no left child return null)
		public void setRight(IAVLNode node); //sets right child
		public IAVLNode getRight(); //returns right child (if there is no right child return null)
		public void setParent(IAVLNode node); //sets parent
		public IAVLNode getParent(); //returns the parent (if there is no parent return null)
		public boolean isRealNode(); // Returns True if this is a non-virtual AVL node
   	public void setHeight(int height); // sets the height of the node
   	public int getHeight(); // Returns the height of the node (-1 for virtual nodes)
	}

//-------------------------------------------  AVLNode class   -----------------------------------------------

  /**
  * public class AVLNode
  *
  * If you wish to implement classes other than AVLTree
  * (for example AVLNode), do it in this file, not in 
  * another file.
  * This class can and must be modified.
  * (It must implement IAVLNode)
  */
 public class AVLNode implements IAVLNode{
		 	
		 	private int key;
		 	private String value;
		 	private IAVLNode left;
		 	private IAVLNode right;
		 	private IAVLNode parent;
		 	private int rank;//the height of the specific node
		 	private int size; //how many nodes in the subtree where i am the root
		 	
		 	public AVLNode() {
		 		this.key=0;
		 		this.value=value;
		 		this.left=null;
		 		this.right=null;
		 		this.rank=-1;
		 	}
		 	
		 	
		 	
			public int getKey()
			{
				return this.key; 
			}
			public String getValue()
			{
				if (rank==-1) {
					return null;}
				return this.value; 
			}
			
			public void setLeft(IAVLNode node)
			{
				this.left=node; 
			}
			public IAVLNode getLeft()
			{
				if (rank!=0)
				{return this.left;}
				return null;
			}
			public void setRight(IAVLNode node)
			{
				this.right=node; 
			}
			public IAVLNode getRight()
			{
				if (rank!=0)
				{return this.right;}
				return null;
		
			}
			public void setParent(IAVLNode node)
			{
				this.parent=node; 
			}
			public IAVLNode getParent()
			{
				if (size!=0) {return parent;}
				return null;
			}
			
			// Returns True if this is a non-virtual AVL node
			public boolean isRealNode()
			{
				if (rank!=-1) {return true;}
				return false;
			}
	   public void setHeight(int height)
	   {
	     this.rank=height;
	   }
	   public int getHeight()
	   {
	     return rank; 
   }
		//------------------ adding a getSize function  ------------
		
		public int getSize() {
			return this.size;
		}
 }

}
 


