package stack.queue;

import java.util.LinkedList;
import java.util.List;

public class StackLL<T> {
    private List<T> data;

    public StackLL() {
        data = new LinkedList<T>();
    }
    public boolean isEempty(){
        return data.isEmpty();
    }
    public int size() {
        return data.size();
    }
    public boolean push(T value){
        return data.add(value);
    }
    public  T pop(){
        return  data.remove(data.size()-1);
    }
    public  T peek(){
        return  data.get(data.size()-1);
    }
    public String toString(){
        return data.toString();
    }
    public static void main(String[] args) {
        StackLL<String> testMe=new StackLL<>();
        testMe.push("1");
        testMe.push("2");
        testMe.push("3");
        System.out.println(testMe.peek());
        System.out.println(testMe.pop());
        testMe.push("6");
        System.out.println(testMe.pop());
        System.out.println(testMe.peek());
        System.out.println(testMe);
        System.out.println(testMe.size());
    }
}
