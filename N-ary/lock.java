class Lock{
    static class Node
    {
        int data;
        List<Node> children;
        boolean isLock;
        boolean isLockable;
        Node parent;
        Node (int val){
            this.data=val;
            this.children=new ArrayList<>();
            this.isLock=false;
            this.isLockable=true;
        }
        Node (int val,Node parent){
            this.data=val;
            this.children=new ArrayList<>();
            this.isLock=false;
            this.isLockable=true;
            this.parent=parent;
        }

    }
    Node root;
    Lock(){
        this.root;
    }
    boolean isLock(Node root)
    {
        return node.isLock;
    }
    static boolean parentlock(Node root)
    {
        if (root==null) return true;
        if (!root.isLockable) return false;
        return parentlock(root.parent);
    }
    /*static boolean childlock(Node root)
    {
        if (root==null ) return true;
        arr=root.childen;

     for (int i=0;i<arr.length;i++)
     {
         if (arr[i].isLockable)
         {
             if ( !childlock(arr[i])) return false;
             else return true;
         }
         return false;
     }*/
    }
    void lock(Node root) {
        if (!isLock(root)) {
            if (parentlock(root.parent)) {
                root.isLock = true;
                root.isLockalbe = false;
                Node tem = root.parent;
                while (tem != null) {
                    tem.isLockable = false;
                }
            }
        }
    }
    vode unlock(Node root)
    {
        if (!isLock(root))
        {
            Node tem = root.parent;
            while (tem != null) {
                tem.isLockable = true;
            }
        }
}