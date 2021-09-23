package PriorityQueue;

public class PQueue {

    public PQueue(){}

    public void heapSort(int tab[]){

        int n = tab.length;

        for(int i=n/2-1;i>=0;i--){
            makeHeap(tab,n,i);
        }
        for(int i = n-1;i>0;i--){
            swap(tab,i,0);
            makeHeap(tab,i,0);
        }
    }

    public void makeHeap(int tab [], int n , int root){

        int newRoot = root;
        int left = 2*root+1;
        int right = 2*root+2;

        if(left < n && tab[left]>tab[newRoot]) newRoot = left;

        if(right < n && tab[right]>tab[newRoot]) newRoot = right;

        if(newRoot != root){
            swap(tab,newRoot,root);
            makeHeap(tab,n,newRoot);
        }

    }

    public void swap(int tab[], int i , int j){
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    public void show(int tab[]){
        for(int i : tab) System.out.print(i + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        PQueue p = new PQueue();
        int tab [] = {2,8,3,4,6,6,5};
        p.show(tab);
        p.heapSort(tab);
        p.show(tab);
    }



}
