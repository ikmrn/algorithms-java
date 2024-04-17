public class CharFinder{
  public char findFirstNonRepeatingChar(String str){
    int[] hashArray = new int[52];

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isAlphabetic(ch)) {
        int hasValue = getHashValue(ch);
        hashArray[hasValue]++;
      }
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isAlphabetic(ch)) {
        int hasValue = getHashValue(ch);
        if (hashArray[hasValue] == 1){
          return ch;
        }
      }
    }
    return '~';
  }

  private int getHashValue(char ch) {
    if (Character.isUpperCase(ch)) {
        return ch - 'A'; // A-Z mapped to 0-25
    } else {
        return ch - 'a' + 26; // a-z mapped to 26-51
    }
  }

}