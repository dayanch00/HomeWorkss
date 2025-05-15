package HomeWork3;

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }


        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int top = q1.poll();


        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }


        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int top = q1.peek();

        q2.offer(q1.poll());


        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}