
public class StackTester
{

    public static void main(String[] args)
    {
        ArrayStack<Integer> aS = new ArrayStack<Integer>();
        LinkedStack<Integer> lS = new LinkedStack<Integer>();
        
        aS.push(3);
        aS.push(5);
        aS.push(10);
        aS.push(11);
        System.out.println(""+ aS.peek() + ", " + aS.pop() + ", " + aS.peek2());
        aS.remove(1);
        
        lS.push(3);
        lS.push(4);
        lS.push(5);
        lS.push(7);
        lS.push(11);
        lS.push(35);
        System.out.println("" + lS.peek()+", "+ aS.pop()+", "+aS.peek2());
    }

}
