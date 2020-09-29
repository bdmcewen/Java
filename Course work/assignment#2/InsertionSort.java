import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort
{
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
    int compCounter = 1, swapCounter = 1, loopCounter = 1, length = 0;
    ArrayList<Integer> tempArr = (ArrayList<Integer>) array.clone();
    length = tempArr.size();


    for (int i = 1; i < length; i++) {
      //prints arrayList
      System.out.printf("\n%6s" + "%3d" + "%14s", "Loop #", loopCounter, ":    Array =  ");
      for (int tempi : tempArr) {
        System.out.printf("%3d", tempi);
      }

      int key = tempArr.get(i);
      int j = i-1;

      System.out.printf("\n%16s" + "%-7d", "    Comparison #", compCounter);
      for (int tempi : tempArr)
      {
        if ((tempArr.indexOf(tempi)) == j+1)
        {
          System.out.printf("%3d", tempArr.get(j + 1));
        }
        else if ((tempArr.indexOf(tempi)) == j)
        {
          System.out.printf("%3d", tempArr.get(j));
        }else {
          System.out.printf("%3s", "");
        }


      }

      while (j >= 0 && (tempArr.get(j) > key))
      {
        tempArr.set(j + 1, tempArr.get(j));
        j--;
      }

      tempArr.set(j+1, key);

      if ((!tempArr.get(j + 1).equals(tempArr.get(i))))
      {
        System.out.printf("\n%10s" + "%-13d", "    Swap #", swapCounter);
        for (int tempi2 : tempArr)
        {

          if (((tempArr.indexOf(tempi2)) == j + 1))
          {
            System.out.printf("%3d", tempArr.get(j + 1));
            swapCounter++;
          }
          if ((tempArr.indexOf(tempi2)) == (i - 1))
          {
            System.out.printf("%3d", tempArr.get(i));
          } else {
            System.out.printf("%3s", "");
          }
        }
      }



      compCounter++;

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
    insertionSort(testData);
    //System.out.println(testData);
  }
}
