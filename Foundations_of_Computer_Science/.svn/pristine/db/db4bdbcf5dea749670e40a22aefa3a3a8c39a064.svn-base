public class Main{

    // brackets matching method
    public static boolean bracketsMatching(String input){
        MyStack stack = new MyStack();
        // searching in the input
        for(int i = 0; i < input.length(); i++){
            // if the left bracket is found, push it to the stack
            if(input.charAt(i) == '{')
                stack.push(new Node("{"));
            else if(input.charAt(i) == '(')
                stack.push(new Node("("));
            else if(input.charAt(i) == '}')
                stack.removeNode("{");
            else if(input.charAt(i) == ')')
                stack.removeNode("(");            
        }
        if(stack.getTop() == null)
            return true;
        else
            return false;
    }

    // reverse queue method
    public static MyQueue reverseQueue(MyQueue queue){
        // if queue is empty
        if(queue.isEmpty() == true)
            return new MyQueue();
        // if queue is not empty, get the length of the queue
        String [] queueDatas = new String[queue.getQueueLength()];
        // while queue is not empty
        while(queue.isEmpty() == false){
            for(int i = 0; i < queueDatas.length; i++)
                queueDatas[i] = queue.dequeue();
        }
        // here the queue is empty, so enqueue in the reverse order
        for(int j = queueDatas.length-1; j >= 0; j--)
            queue.enqueue(new Node(queueDatas[j]));
        // now the queue is reversed
        return queue;
    }

    public static void main(String[] args) {
        // for testing the brackets matching
        boolean test1 = bracketsMatching("{}");
        boolean test2 = bracketsMatching("{");
        boolean test3 = bracketsMatching("(1+2) * {(2+3)*(3+4)}");
        boolean test4 = bracketsMatching("(1+2) * {{2+3)*(3+4}}");
        boolean test5 = bracketsMatching("(1+2) * {(2+3)*(3+4)}");
        boolean [] matches = {test1, test2, test3, test4, test5};
        for(int i = 0; i < matches.length; i++)
            System.out.println(matches[i]);

        // for reversing the queue
        Node [] nodes1 = {new Node("av"), new Node("bv"), new Node("cv"), new Node("dv")};
        Node [] nodes2 = {new Node("Go"), new Node("byebye"), new Node("return"), new Node("stay"), new Node("OK"), new Node("Holy")};
        Node [] nodes3 = {new Node("dog"), new Node("Maria"), new Node("peter"), new Node("goodJob"), new Node("Uh-huh")};

        // put nodes in three queues
        MyQueue queue1 = new MyQueue();
        MyQueue queue2 = new MyQueue();
        MyQueue queue3 = new MyQueue();

        for(int i = 0; i < nodes1.length; i++)
            queue1.enqueue(nodes1[i]);
        for(int i = 0; i < nodes2.length; i++)
            queue2.enqueue(nodes2[i]);
        for(int i = 0; i < nodes3.length; i++)
            queue3.enqueue(nodes3[i]);

        System.out.println("Reversed queue 1: ");
        reverseQueue(queue1).displayQueue();
        System.out.println();
        System.out.println("Reversed queue 1: ");
        reverseQueue(queue2).displayQueue();
        System.out.println();
        System.out.println("Reversed queue 1: ");
        reverseQueue(queue3).displayQueue();
        System.out.println();
    }
}