import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort
{
  public static ArrayList<Integer> selectionSort(ArrayList<Integer> array)
  {
    int compCounter = 1, swapCounter = 1, loopCounter = 1;
    ArrayList<Integer> tempArr = (ArrayList<Integer>) array.clone();
    int length = tempArr.size();

    for (int i = 0; i < length; i++) {
      System.out.printf("\n%6s" + "%3d"  + "%14s" , "Loop #" , loopCounter , ":    Array =  ");
      for(int tempi: tempArr){System.out.printf("%3d",tempi);}

      int min = i;
      for (int j = i + 1; j < length; j++) {
        System.out.printf("\n%16s" + "%-4d" , "    Comparison #" , compCounter);
        for(int tempi: tempArr)
        {
          if ((tempArr.indexOf(tempi)) == j)
          {
            System.out.printf("%3d" + "%3d", tempArr.get(min) ,tempArr.get(j) );
          }
          else {
            System.out.printf("%3s", "");
          }
        }

        if (tempArr.get(j) < tempArr.get(min)) {
          min = j;
        }
        System.out.printf("%7s" + "%2d" + "%8s" + "%d" + "%s", "min=", tempArr.get(min), "array[", min, "]");
        compCounter++;
      }
      int c = tempArr.get(min);
      tempArr.set(min, tempArr.get(i));
      tempArr.set(i, c);
      System.out.printf("\n%6s" + "%-13d" , "    Swap #" , swapCounter );
      for(int tempi2: tempArr)
      {
        if ((tempArr.indexOf(tempi2)) == i)
        {
          System.out.printf("%3d", tempArr.get(i) );
        }
        if ((tempArr.indexOf(tempi2)) == min-1)
        {
          System.out.printf("%3d", tempArr.get(min) );
        }
        else {
          System.out.printf("%3s", "");
        }
      }
      swapCounter++;
      loopCounter++;
    }
    System.out.print("\n\nAnalysis:");
    System.out.printf("\n%-16s" + "%4d", "    Comparisons:", compCounter);
    System.out.printf("\n%-16s" + "%4d", "    Swaps:", swapCounter);
    System.out.printf("\n%-16s" + "%4d" + "%2s" + "%3d" + "%5s " + "%3d" ,"    Work:", compCounter, " +", swapCounter, "*5 = ", (compCounter+(swapCounter*5)));
      return tempArr;
  }




  public static void main(String[] args) {
    ArrayList<Integer> testData = new ArrayList<>();
    testData.add(45);
    testData.add(37);
    testData.add(92);
    testData.add(62);
    testData.add(17);
    testData.add(51);
    testData.add(81);
    testData.add(6);
    testData.add(29);
    testData.add(74);
    selectionSort(testData);

    //System.out.println(testData);
  }
}
