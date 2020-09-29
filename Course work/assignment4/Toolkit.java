/*******************************************************************************
 *                  Assignment 4 - String Manipulation                          *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Assignment assign-#4                                       *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  11-15-2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This file defines the string manipulation methods                            *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is                       *
 * original work, without use of outside sources.                               *
 *******************************************************************************/

import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Toolkit {

    //region Attributes
    private int index = 0;
    private int subsequenceIndex = 0;
    int seqLength;
    private String lcData1;
    private String lcData2;
    private String raw_data;
    private String dataRNA;
    private String validChars = "ACGT";
    private String sequence;
    private String newData;
    private String savePath;
    private String tempstr1;
    private String temPSequence;
    private StringBuilder data = new StringBuilder();
    private int minOccurrences;
    private boolean checkChars = true;
    private char[] rawChars;
    private List<String> result = new ArrayList<>();
    private StringBuilder printArray = new StringBuilder();
    private final Scanner sc = new Scanner(System.in);
    private HashMap<String, Integer> onesCounter;
    private HashMap<String, Integer> twosCounter;
    private HashMap<String, Integer> threesCounter;
    TreeMap<String, Integer> sorted = new TreeMap<>();
    final DynamicLongestCommonSubsequence lcs = new DynamicLongestCommonSubsequence();
    //endregion

    //region Constructors

    public Toolkit(final String raw_data, final StringBuilder data, final String dataRNA) {
        super();
        this.raw_data = raw_data;
        this.data = data;
        this.dataRNA = dataRNA;
    }

    public Toolkit(final String raw_data) {
        super();
        this.raw_data = raw_data;
    }

    public Toolkit() {
        super();
    }



    //endregion

    //region Getters & Setters



    public String getLcData1() {
        return lcData1;
    }

    public void setLcData1(final String lcData1) {
        this.lcData1 = lcData1;
    }

    public String getLcData2() {
        return lcData2;
    }

    public void setLcData2(final String lcData2) {
        this.lcData2 = lcData2;
    }

    public String getRaw_data() {
        return raw_data;
    }

    public void setRaw_data(final String raw_data) {
        this.raw_data = raw_data;
    }

    public StringBuilder getData() {
        return data;
    }

    public void setData(final StringBuilder data) {
        this.data = data;
    }

    public String getDataRNA() {
        return dataRNA;
    }

    public void setDataRNA(final String dataRNA) {
        this.dataRNA = dataRNA;
    }

    public String getValidChars() {
        return validChars;
    }

    public void setValidChars(final String validChars) {
        this.validChars = validChars;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(final String sequence) {
        this.sequence = sequence;
    }

    public int getMinOccurrences() {
        return minOccurrences;
    }

    public void setMinOccurrences(final int minOccurrences) {
        this.minOccurrences = minOccurrences;
    }

    public boolean isCheckChars() {
        return checkChars;
    }

    public void setCheckChars(final boolean checkChars) {
        this.checkChars = checkChars;
    }

    public char[] getRawChars() {
        return rawChars;
    }

    public void setRawChars(final char[] rawChars) {
        this.rawChars = rawChars;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(final String newData) {
        this.newData = newData;
    }

    public HashMap<String, Integer> getOnesCounter() {
        return onesCounter;
    }

    public void setOnesCounter(final HashMap<String, Integer> onesCounter) {
        this.onesCounter = onesCounter;
    }

    public HashMap<String, Integer> getTwosCounter() {
        return twosCounter;
    }

    public void setTwosCounter(final HashMap<String, Integer> twosCounter) {
        this.twosCounter = twosCounter;
    }

    public HashMap<String, Integer> getThreesCounter() {
        return threesCounter;
    }

    public void setThreesCounter(final HashMap<String, Integer> threesCounter) {
        this.threesCounter = threesCounter;
    }

    //endregion

    //region Behaviors

    //region Custom Behaviors
    /*
otherIdea

PURPOSE: holder for possible methods
PARAMETERS:
none
RETURN VALUE:  none
*/
    private Boolean sequenceCheck(@NotNull final StringBuilder data, final String sequence) {
        final Boolean tempBool;
        String tempData = data.toString();
        tempBool = tempData.contains(sequence);

        return tempBool;
    }

    /*
otherIdea

PURPOSE: holder for possible methods
PARAMETERS:
none
RETURN VALUE:  none
*/
    StringBuilder preProcessing(final String raw_data) {
        data.delete(0,data.length());
        //testing checkValidChars
        this.detectErrors(raw_data);

        if (!this.checkChars) {
            System.out.println("Data set Contains invalid Characters");
            System.out.println("Stripping Errors from Raw Data");
            this.stripErrors(raw_data);
        }
        else {
            System.out.println("Data set Contains no invalid Characters");
            for (final char ch2 : getRawChars()) data.append(ch2);
        }
        return data;
    }

    // Returns true if str1[] is a subsequence of str2[]
    // m is length of str1 and n is length of str2
    private static boolean isSubSequence(final String str1, final String str2, final int m, final int n)
    {
        // Base Cases
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        // If last characters of two strings are matching
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return isSubSequence(str1, str2, m-1, n-1);

        // If last characters are not matching
        return isSubSequence(str1, str2, m, n-1);
    }

    //finds all of the X-letter-long sequences that occur more than once
    public void findRepeatedDnaSequences(final StringBuilder data) throws IOException, InterruptedException {


        System.out.print("Please enter the length of sequence to search for=>");
        final String tl = sc.nextLine();
        seqLength = Integer.parseInt(tl);

        if(null == data || 10 > data.length()){
            return;
        }

        final HashMap<Character, Integer> dict = new HashMap<>();
        dict.put('A', 0);
        dict.put('C', 1);
        dict.put('G', 2);
        dict.put('T', 3);

        int hash=0;
        final int mask = (1<<20) -1;

        final HashSet<Integer> added = new HashSet<>();
        final HashSet<Integer> temp = new HashSet<>();

        for(int i=0; i<data.length(); i++){
            hash = (hash<<2) + dict.get(data.charAt(i));

            if(i>=seqLength){
                hash&=mask;
                if(temp.contains(hash) && !added.contains(hash)){
                    result.add(data.substring(i-(seqLength-1), i+1));
                    added.add(hash);
                }
                temp.add(hash);
            }
        }

        System.out.println("Generate report to view results");
        returnToMenu();
    }

    //returns to menu
    private static void returnToMenu() throws IOException, InterruptedException {
        System.out.println("\n\nPress Enter key to continue...");
        try {
            System.in.read();
            Menus.processingMenu();
        } catch (Exception e) {
        }
        Menus.processingMenu();
    }

    //region SimpleSequencesAnalysis methods
    //Credit to Kevin Ritter for introducing me to hashmaps
    private void countOnes() {
        onesCounter = new HashMap<>();
        String data = getData().toString();

        for(char c: data.toCharArray()){
            if(!this.onesCounter.containsKey(Character.toString(c))) {
                this.onesCounter.put(Character.toString(c),1);
            }
            else {
                this.onesCounter.put(Character.toString(c), this.onesCounter.get(Character.toString(c)) + 1);
            }
        }

    }

    private void countTwos() {
        twosCounter = new HashMap<>();
        String data = getData().toString();

        String tempKey;
        for(int i = 2; i < getData().length();i++)
        {
            tempKey = data.subSequence(i - 2 , i).toString();
            if(!this.twosCounter.containsKey(tempKey)) {
                this.twosCounter.put(tempKey,1);
            }
            else {
                this.twosCounter.put(tempKey, this.twosCounter.get(tempKey) + 1);
            }
        }

    }

    private void countThrees() {
        threesCounter = new HashMap<>();
        String data = getData().toString();
        String tempKey;

        for(int i = 3; i < getData().length();i++)
        {

            tempKey = data.subSequence(i - 3 , i).toString();

            if(!this.threesCounter.containsKey(tempKey)) {
                this.threesCounter.put(tempKey,1);
            }
            else {
                this.threesCounter.put(tempKey, this.threesCounter.get(tempKey) + 1);
            }
        }

    }

    public void sortMapByKey(HashMap map) {


            sorted.clear();
            sorted.putAll(map);

            for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
                System.out.println("Sequence '" + entry.getKey() +
                        "' Occures " + entry.getValue() + " times");
            }

    }

    public void promptEnterKey() throws IOException {
        System.out.println("Press \"ENTER\" to continue...");

            System.in.read();

    }

    public void waiting() throws InterruptedException {
        WaitTool wt= new WaitTool();
        for (int i = 0; i < 16; i++) {
            wt.animate(i + "");
            //simulate a piece of task
            Thread.sleep(700);
        }
    }
        //endregion

    //endregion

    //region Required Behaviors

    //region Gathering Data

    /*
        userDNAentry

        PURPOSE:
        Allow the user to enter a DNA-sequence manually, and store in the raw_data attribute.

        PARAMETERS:
        list-parameters-and-purpose
        RETURN VALUE:  describe-return-value
        */
    String userDNAentry() {
        System.out.print("Enter origin =>");
        setRaw_data(sc.nextLine());
        setRawChars(raw_data.toCharArray());

        return getRaw_data();

//        System.out.println(getRaw_data());  //for testing
    }

    /*
        userDNAentry

        PURPOSE:
        Allow the user to enter a DNA-sequence manually, and store in the raw_data attribute.

        PARAMETERS:
        list-parameters-and-purpose
        RETURN VALUE:  describe-return-value
        */
    public String userSequence() throws IOException {
        System.out.print("Enter sequence =>");
        final String str = sc.nextLine();
        System.out.println("You entered " + str);
        System.out.println("Is this correct?");
        String response = sc.nextLine();
        try {
            char X = response.toUpperCase().charAt(0);

            if (X == 'N') {
                System.out.println("Sorry, let's try that again.");
                promptEnterKey();
                userSequence();
            }

            if (X == 'Y') {
                System.out.println("Got it!");
                promptEnterKey();
            }
            else {
                System.out.println("I didn't understand your response, lets go again");
                promptEnterKey();
                userSequence();
            }
        }
        catch(Exception e)
        {
            System.out.println("Well that didn't work, lets try that again");
            promptEnterKey();
            userSequence();
        }

        return str;
    }

    /*
readDNAfromFile

PURPOSE:
Read a file containing DNA and store in the raw_data attribute.
You may have the user enter the filename if none is given.

PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public String readDNAfromFile() throws IOException {

        final String filePath;

        System.out.print("Enter absolute file path for the input file=>");
        try {
            filePath = sc.nextLine();

            //read input using file Reader
            final File file = new File(filePath);
            final Scanner sc1 = new Scanner(file);

            while (sc1.hasNext()) {
                setRaw_data(sc1.next());
            }
            setRawChars(raw_data.toCharArray());

            System.out.println("File has been read successfully");
            promptEnterKey();
        }
        catch (Exception e){
            System.out.println("File not found, please try again");
            promptEnterKey();
            readDNAfromFile();
        }
        return getRaw_data();
//        System.out.println(getRaw_data());  //for testing
    }

    /*
generateRandomDNA

PURPOSE:
Save the preprocessed data into a filename specified by the user.  If no file is specified,
then produce no file output.
PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public void generateRandomDNA() throws InterruptedException, IOException {
        System.out.println("Enter length of DNA string:");
        final String tempLength = sc.nextLine();
        final int dnaLength = Integer.parseInt(tempLength);

        final Random rando = new Random();
        final char[] dna;
        dna = new char[dnaLength];
        for (int i = 0; i < dnaLength; i++) {
            final int tempC = rando.nextInt(4);
            if (0 == tempC)
                dna[i] = 'A';
            if (1 == tempC)
                dna[i] = 'G';
            if (2 == tempC)
                dna[i] = 'C';
            if (3 == tempC)
                dna[i] = 'T';

        }

        final StringBuilder sb = new StringBuilder();
        for (final char ch : dna) sb.append(ch);
        raw_data = sb.toString();
        setRawChars(raw_data.toCharArray());

        waiting();

        System.out.println();
        System.out.println("How was that for Random?");
        System.out.println();
        System.out.println("Oh and your DNA was generated also, shall we sally forth?");
        preProcessing(raw_data);

        System.out.println("Would you like to save this to a file now?");
        String response = sc.nextLine();
        try {
            char X = response.toUpperCase().charAt(0);

            if (X == 'N') {
                System.out.println("Sorry, let's try that again.");
                promptEnterKey();
                userSequence();
            }

            if (X == 'Y') {
                System.out.println("Got it!");

                saveDNAtoFile();
            }
            else {
                System.out.println("I didn't understand your response, lets go again");
                promptEnterKey();
                userSequence();
            }
        }
        catch(Exception e)
        {
            System.out.println("Well that didn't work, lets try that again");
            promptEnterKey();
            userSequence();
        }


//        System.out.println(getRaw_data());  //for testing
        returnToMenu();
    }

    //endregion

    /*
saveDNAtoFile

PURPOSE:
Save the preprocessed data into a filename specified by the user.  If no file is specified,
then produce no file output.

PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public void saveDNAtoFile() throws IOException, InterruptedException {

        System.out.println("Enter path to save file to");
        savePath = sc.nextLine();
        Files.write(Paths.get(savePath), raw_data.getBytes());

        // D:\Git\personal\Files\UNC\Fall 2019\CS 200\assignment4\src\set1000.txt

        System.out.println("Your file has been saved to " + savePath);
        returnToMenu();
    }

    /*
otherIdea

PURPOSE: holder for possible methods
PARAMETERS:
none
RETURN VALUE:  none
*/
    public void detectErrors(final String dataString) {
        boolean tempBool;

        //dataString.replaceAll(" ", "");
        // convert String raw_data to char[] array

        final char[] chars2 = dataString.toCharArray();

        System.out.println(chars2);
        // iterate over char[] array using enhanced for loop
        if (checkChars) for (final char ch2 : chars2) {
            tempBool = false;
            for (int i = 0; i < validChars.length(); i++)
                if (ch2 == validChars.charAt(i)) {
                    tempBool = true;
                    break;
                }
            if (!tempBool) {
                checkChars = false;
                break;
            }
        }

    }

    /*
stripErrors

PURPOSE:
Find and remove any errors in raw_data.  Only A,C,G, and T are acceptable characters.
If the DNA is of a reasonable length, print the nucleotide list as small letters,
using capital letters as errors. For example, actRggattDccg indicates that R and D are errors.
Print a report indicating the number of errors encountered for each character.
It can be useful to know if there was just a bunch of spaces and numbers, or if there are actual
letters that are incorrect.  Save the legal characters in the raw_data attribute into the data attribute.
After this method, the data attribute should contain only legal DNA characters, and is ready for processing.

PARAMETERS:
raw_data
RETURN VALUE:  returns data
*/
    public StringBuilder stripErrors(final String raw_data) {
        // iterate over char[] array using enhanced for loop
        for (final char ch2 : getRawChars()) {
            for (int i = 0; i < validChars.length(); i++) {
                if (ch2 == validChars.charAt(i))
                {
                    data.append(ch2);
                }

            }
        }
        return data;
    }

    /*
generateRna

PURPOSE:
Not all bioinformatics algorithms are complex.  In ribonucleic acid (RNA) uracil (U) is used instead
of thymine (T). Everything is exactly the same except that every T is replaced with U.
Generate the corresponding RNA sequence for the stored DNA sequence, saving the result in the
dataRNA attribute.
PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public void generateRna(@NotNull final StringBuilder data) throws IOException, InterruptedException {

        setDataRNA(data.toString().replaceAll("T", "U"));
        System.out.println("RNA generated:");
        System.out.println(getDataRNA());

        returnToMenu();
    }

    /*
searchSequence

PURPOSE:
Search for a given sequence within the DNA.  Return the index of the first nucleotide in the first occurrence
of the sequence, or -1 if it is not present.
PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public void searchSequence(@NotNull final StringBuilder data) throws IOException, InterruptedException {
        temPSequence = userSequence();

        if (sequenceCheck(data, temPSequence)) {
            index = data.toString().indexOf(temPSequence);
            System.out.println("Sequence " + temPSequence + " found at index: " + index);
        } else {
            System.out.println(temPSequence + "not found");
        }

        Toolkit.returnToMenu();
    }

    /*
simpleSequenceAnalysis

PURPOSE:
This is the tester method for the SimpleSequenceAnalysis method
PARAMETERS:
StringBuilder Data to be analysised
RETURN VALUE:  none
*/
    public void simpleSequenceAnalysis(final StringBuilder data) throws IOException, InterruptedException {

        countOnes();
        countTwos();
        countThrees();

        System.out.println("Analysis complete");
        System.out.println("Generate report to view results");
        returnToMenu();

    }

    /*
searchSubsequence

PURPOSE:
Search for a subsequence within the DNA.  Return the index of the first occurrence of the subsequence,
or -1 if it is not present.  Note that in a subsequence, the nucleotides need not be adjacent.
PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    public void searchSubsequence(final StringBuilder data) throws IOException {

        tempstr1 = userSequence();
        final String tempstr2 = data.toString();
        final int m = tempstr1.length();
        final int n = tempstr2.length();
        final boolean res = isSubSequence(tempstr1, tempstr2, m, n);
        if(res) {
            subsequenceIndex = tempstr2.indexOf(tempstr1.charAt(0));
            System.out.println("Subsequence "+ tempstr1 + " found at " + subsequenceIndex);
        }
        else
            System.out.println("-1");
    }

    /*
replaceSequence

PURPOSE:
Replace the first occurrence of a given sequence from the DNA with another sequence.
Return a 1 if successful, and -1 if sequence is not present.
PARAMETERS:
none
RETURN VALUE:  none
*/
    public void replaceSequence() throws IOException, InterruptedException {
        final String oldSequence = this.userSequence();
        final String newSequence = this.userSequence();

        newData = data.toString().replace(oldSequence, newSequence);
        System.out.println(getNewData());

        returnToMenu();
    }

    //region Print Methods

    /*
generateReport

PURPOSE:
Generate a report demonstrating all methods implemented.  Print the raw data, DNA, and RNA in their entirety,
but only give a sample of the data (10 lines or so) if it is too long to be printed reasonably.
In addition to printing, this method should save the same report into a file with the name specified by a parameter.
PARAMETERS:
none
RETURN VALUE:  none
*/
    public void generateReport() {
        /*the report will only contain the information
        * which pertains to the methods run during the active session
        * therefore each report will be unique.*/

        if (null != raw_data) {
            System.out.println("Raw Data is:");
            System.out.println(this.getRaw_data());
            System.out.println();
        }
        if (null != data) {
            System.out.println("Processed Data:");
            System.out.println(this.getData());
            System.out.println();
        }
        if (null != dataRNA) {
            System.out.println("Processed RNA Data:");
            System.out.println(this.getDataRNA());
            System.out.println();
        }
        if(null != savePath) {
            System.out.println("Your file has been saved to: ");
            System.out.println(savePath);
            System.out.println();}
        if(0 != index){
            System.out.println("Sequence " + temPSequence + " found at index: " + index);
        }
        if(0 != index){
            System.out.println("Subsequence "+ tempstr1 + " found at " + subsequenceIndex);;
        }
        if(null != printArray ){
            System.out.println("Sequence " + temPSequence + " found at index: " + printArray.toString());
            System.out.println();
        }
        if (null != result) {
            System.out.println("Repeating sequences of length:" + seqLength);
            System.out.println(this.result);
            System.out.println();
        }
        if (null != getOnesCounter()){

            System.out.println("One Character Sequences");
            sortMapByKey(onesCounter);
            System.out.println();

            System.out.println("Two Character Sequences");
            sortMapByKey(twosCounter);
            System.out.println();

            System.out.println("Three Character Sequences");
            sortMapByKey(threesCounter);
            System.out.println();
        }
        if(null != lcs.lcsSB){
            System.out.print("Longest common Subsequence length: " + lcs.length);
            System.out.println("Longest common Subsequence: " + lcs.lcsSB.toString());
        }
    }

    //endregion

    //endregion

    //region Optional Behaviors

    /*
multiSearchSequence

PURPOSE:
Same as searchSequence but return an ArrayList of all indices for each occurrence of the sequence
within the DNA.  For no occurrences, return an empty list.
PARAMETERS:
list-parameters-and-purpose
RETURN VALUE:  describe-return-value
*/
    void multiSearchSequence(@NotNull final StringBuilder data) throws IOException {
        temPSequence = userSequence();
        int counter = 0;
        String tempData = data.toString();
        int tempIndex = tempData.indexOf(temPSequence);
        final ArrayList<Integer> indexArray = new ArrayList<>();


        if (sequenceCheck(data, temPSequence)) {
            while (0 <= tempIndex && tempIndex < data.toString().length()) {
                tempData = data.toString();
                tempIndex = tempData.indexOf(temPSequence, tempIndex + 1);
                indexArray.add(tempIndex);

                counter++;
            }

            for (final int i : indexArray) {
                if ((-1) != i)
                    printArray.append(i).append(" ");
            }
            System.out.println("Sequence " + temPSequence + " found at index: " + printArray.toString());
        } else
            {
            System.out.println("Sequence not found");
        }


    }

    /*
longestCommonSubsequence

PURPOSE: not provided
PARAMETERS:
none
RETURN VALUE:  none
*/
    private void LCSD(final String data1, final String data2) throws IOException, InterruptedException {

        final char[] X= data1.toCharArray();
        final char[] Y= data2.toCharArray();
        final int m = X.length;
        final int n = Y.length;
        lcs.lcs( X, Y, m, n );

        System.out.println("Length of LCS is" + " " + lcs.length);

        returnToMenu();
    }

    void LCSD() throws IOException, InterruptedException {

        final String templcData1 = readDNAfromFile();
        lcData1 = preProcessing(templcData1).toString();

        final String templcData2 = readDNAfromFile();
        lcData2 = preProcessing(templcData2).toString();

        System.out.println("lcdata1 = " + getLcData1());
        System.out.println("lcdata2 =" + getLcData2());

        LCSD(getLcData1(), getLcData2());
    }

    //endregion

    //endregion

    public static void main(final String[] args) throws IOException, InterruptedException {
        final Toolkit tk = new Toolkit();

//        tk.userDNAentry();
        tk.readDNAfromFile();
//        tk.generateRandomDNA();
//        tk.saveDNAtoFile();
//        tk.userSequence();
        tk.preProcessing(tk.raw_data);
//        tk.generateRna(tk.data);
//        tk.searchSequence(tk.data);
//        tk.multiSearchSequence(tk.data, tk.sequence);
        tk.simpleSequenceAnalysis(tk.data);
//        tk.searchSubsequence(tk.data);
//        tk.replaceSequence();
//        tk.findRepeatedDnaSequences(tk.data);
//        tk.LCSD();
        tk.generateReport();
//        tk.toString();
    }
}


