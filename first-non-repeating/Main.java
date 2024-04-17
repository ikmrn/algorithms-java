public class Main{
  public static void main(String[] args){
    String greenApple = "A Green Apple";
    CharFinder finder = new CharFinder();
    char character = finder.findFirstNonRepeatingChar(greenApple);
    System.out.println(character);
    String repeat = "AABJBJGGASASKFFK";
    character = finder.findFirstNonRepeatingChar(repeat);
    System.out.println(character);
    String last = "A Green AppleA Green Applef";
    character = finder.findFirstNonRepeatingChar(last);
    System.out.println(character);
  }
}