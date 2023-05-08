import java.awt.geom.Point2D;


public class QuickSort {


    /**
     * Default Contructor
     */
    public QuickSort() {
        //Empty constructor --- do nothing
    }

    /**
     * The main function that implements QuickSort
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @param orderBy    --> compareX or compareY
     *                   compareX: sort minimum to maximum arr[] by X point
     *                   compareY: sort minimum to maximum arr[] by Y point
     */
    public void sort(Point2D.Double[] arr, int startIndex, int lastIndex, String orderBy) {
        
        int pivotNum;
        if (lastIndex-startIndex>1) {
            if (orderBy.equals("compareX")) {
                pivotNum = partitionX(arr, startIndex, lastIndex);
                sort(arr, startIndex, pivotNum - 1, "compareX");
                sort(arr, pivotNum , lastIndex, "compareX");
            }
            else if (orderBy.equals("compareY")) {
                pivotNum = partitionY(arr, startIndex, lastIndex);
                sort(arr, startIndex, pivotNum - 1, "compareY");
                sort(arr, pivotNum , lastIndex, "compareY");
            }
        }
    }

    /**
     * A utility function to swap two elements
     *
     * @param arr --> Array to be sorted
     * @param i   --> first index
     * @param j   --> second index
     */
    private void swap(Point2D.Double[] arr, int i, int j) {
        Point2D.Double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Get Median of 3 order by Point.X
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianX(Point2D.Double[] arr, int left, int right) {
        int middle = (left+right)/2;
        if(arr[left].getX() > arr[middle].getX())
            swap(arr,left,middle);
        if(arr[left].getX() > arr[right].getX())
            swap(arr,left,right);
        if(arr[middle].getX() > arr[right].getX())
            swap(arr,middle,right);

        swap(arr,middle,right-1);
        return arr[right-1];
    }

    /**
     * Get Median of 3 order by Point.Y
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianY(Point2D.Double[] arr, int left, int right) {
        //Write your codes here
        int middle = (left+right)/2;
        if(arr[left].getY() > arr[middle].getY())
            swap(arr,left,middle);
        if(arr[left].getY() > arr[right].getY())
            swap(arr,left,right);
        if(arr[middle].getY() > arr[right].getY())
            swap(arr,middle,right);

        swap(arr,middle,right-1);
        return arr[right-1];
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.X
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int partitionX(Point2D.Double[] arr, int startIndex, int lastIndex) {
        Point2D.Double pivot = getMedianX(arr, startIndex, lastIndex);

        int first=startIndex; 
        int last=lastIndex;
        while(true){
            while(arr[++first].getX()<pivot.getX());
            while(arr[--last].getX()>pivot.getX());
            if(first<last) swap(arr,first,last);
            else break;
        }
        swap(arr,first,lastIndex - 1);
        return first;
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.Y
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int partitionY(Point2D.Double[] arr, int startIndex, int lastIndex) {
        Point2D.Double pivot = getMedianY(arr, startIndex, lastIndex);

        int first = startIndex;
        int last = lastIndex;
        while(true){
            while(arr[++first].getY()<pivot.getY());
            while(arr[--last].getY()>pivot.getY());
            if(first<last) swap(arr,first,last);
            else break;
        }
        swap(arr,first,lastIndex - 1);
        return first;
    }

}
