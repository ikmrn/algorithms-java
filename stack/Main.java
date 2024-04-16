public class Main{
  public static void main(String[] args){
    ArrayStack st = new ArrayStack(5);
    System.out.println(st.isEmpty());
    st.push(3);
    st.push(5);
    st.push(3);
    st.push(36);
    st.push(65);
    st.push(61);
    System.out.println(st);
    System.out.println(st.isEmpty());
    System.out.println(st.pop());
    System.out.println(st.peek());
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.pop());
  }
}