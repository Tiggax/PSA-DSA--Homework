package psa.naloga3;


// kjluč votlišča in polje naslednikov
// consturktor
public class NodeSkipList {
    public int key;
    public NodeSkipList next[];

    public NodeSkipList(int key, NodeSkipList[] arraylist){
        this.key = key;
        this.next = arraylist;
    }
}
