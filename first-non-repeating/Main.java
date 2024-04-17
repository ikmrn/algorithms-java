public class Main{
  public static void main(String[] args){
    String greenApple = "A Green Apple";
    CharFinder finder = new CharFinder();
    char character = finder.findFirstRepeatingChar(greenApple);
    System.out.println(character);
    String repeat = "AABJBJGGASASKFFK";
    character = finder.findFirstRepeatingChar(repeat);
    System.out.println(character);
    String last = "A Green AppleA Green Applef";
    character = finder.findFirstRepeatingChar(last);
    System.out.println(character);
    String non = "asdfghjklqwertyuip";
    character = finder.findFirstRepeatingChar(non);
    System.out.println(character);
  }

}