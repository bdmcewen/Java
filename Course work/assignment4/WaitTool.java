public class WaitTool {
    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

    public void animate(String line) {
        switch (anim) {
            case 1 -> print("Chitty Bang Bang");
            case 2 -> print("Chitty Chitty Bang Bang");
            case 3 -> print("We love you");
            case 4 -> print("and ");
            case 5 -> print("our");
            case 6 -> print("pretty");
            case 7 -> print("Chitty Bang Bang");
            case 8 -> print("Chitty Chitty Bang Bang");
            case 9 -> print("loves us too!");
            case 10 -> print("Oh");
            case 11 -> print("You");
            case 12 -> print("Pretty");
            case 13 -> print("Chitty Bang Bang");
            case 14 -> print("Chitty Chitty Bang Bang");
            case 15 -> print("\uD83D\uDE00");
            default -> {
                anim = 0;
                print("Ready!!!");
            }
        }
        anim++;
    }
}