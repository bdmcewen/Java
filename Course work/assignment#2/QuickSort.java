import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort
{
  public static int compCounter = 1, swapCounter = 1, loopCounter = 1, length = 0;

  public static int partition(ArrayList<Integer> tempArr, int p, int r)
  {
    length = tempArr.size();
    int pivot = tempArr.get(r);

    System.out.printf("\n%6s" + "%3d"  + "%14s" , "Level " , loopCounter , ":    Array =  ");
    for(int tempi: tempArr){System.out.printf("%3d",tempi);}

    System.out.printf("\n%6s" + "%2d", "Low = ", p);
    System.out.printf("\n%7s" + "%2d", "High = ", r);
    System.out.printf("\n%8s" + "%2d", "Pivot = ", pivot);


    // lastSmall refers to the last index that points to a value less
    // than the pivot where lastSmall <= i
    int lastSmall = p - 1;
    for (int i = p; i <= r; i++)
    {
      System.out.printf("\n%16s" + "%-7d" , "    Comparison #" , compCounter);
      for(int tempi: tempArr)
      {
        if ((tempArr.indexOf(tempi)) == i)
        {
          System.out.printf("%3d", tempArr.get(i));
        }
        else {
           System.out.printf("%3s", "");
        }
      }

      if (tempArr.get(i) <= pivot) {
        lastSmall++;

        // Swap arr[lastSmall] and arr[i]

        int copy = tempArr.get(lastSmall);
        tempArr.set(lastSmall, tempArr.get(i));

        tempArr.set(i, copy);
        System.out.printf("\n%6s" + "%-13d" , "    Swap #" , swapCounter );
        for(int tempi: tempArr)
        {
          if ((tempArr.indexOf(tempi)) == i)
          {
            System.out.printf("%3d", tempArr.get(i) );
          }
          if((tempArr.indexOf(tempi)) ==lastSmall)
          {
            System.out.printf("%3d", tempArr.get(lastSmall) );
          }
          else {
            System.out.printf("%3s", "");
          }
        }
        swapCounter++;
      }
      compCounter++;
    }
    loopCounter++;
    return lastSmall;
  }

  public static void quickSort(ArrayList<Integer> arr, int p, int r) {

    if (p < r) {
      int pivot = partition(arr, p, r);
      System.out.print("(stop)\n");
      quickSort(arr, p, pivot-1); // <-- compares left of pivot
      System.out.print("(stop)\n");
      quickSort(arr, pivot+1, r);// <-- compares right of pivot

      System.out.println();
    }
  }

  public static ArrayList<Integer> quickSort(ArrayList<Integer> array) {

    ArrayList<Integer> tempArr = (ArrayList<Integer>) array.clone();


    quickSort(tempArr, 0, tempArr.size() - 1);
    System.out.print("\n\nAnalysis:");
    System.out.printf("\n%-16s" + "%4d", "    Comparisons:", compCounter);
    System.out.printf("\n%-16s" + "%4d", "    Swaps:", swapCounter);
    System.out.printf("\n%-16s" + "%4d" + "%2s" + "%3d" + "%5s " + "%3d" ,"    Work:", compCounter, " +", swapCounter, "*5 = ", (compCounter+(swapCounter*5)));
      return tempArr;
  }


  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();
    testData.add(69);
    testData.add(81);
    testData.add(22);
    testData.add(48);
    testData.add(13);
    testData.add(38);
    testData.add(93);
    testData.add(14);
    testData.add(45);
    testData.add(58);
    testData.add(79);
    testData.add(72);

    quickSort(testData);
    //System.out.println(testData);
  }

}
