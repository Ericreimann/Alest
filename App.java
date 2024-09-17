
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
        
        String a=l.toStringBackToFront("aaaaa");
       // System.out.println("size="+l.size());
    }
}
