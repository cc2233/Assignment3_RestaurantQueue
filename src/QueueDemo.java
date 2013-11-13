import java.util.LinkedList;

public class QueueDemo {

        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                CirQueue<Integer> q = new CirQueue<Integer>();
                q.offer(1);
                q.offer(2);
                q.offer(2);
                q.offer(3);
                System.out.println("before " +q.toString());
//                System.out.println("After " +q.contains(2));
                q.remove(2);
                System.out.println("After " +q);
                q.remove(3);
                System.out.println("After " +q);
                q.remove(1);
                System.out.println("After " +q);
                q.remove(10);
                /*LinkedList alist = new LinkedList();
                alist.add("A");
                alist.add("B");
                System.out.println(alist.iterator().hasNext());
                System.out.println(alist.iterator().next());
                System.out.println((alist.iterator().next());
                */
        }

}