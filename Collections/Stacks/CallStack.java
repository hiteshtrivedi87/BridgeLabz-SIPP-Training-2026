package Collections.Stacks;

class CallStack {
    private static class Frame {
        String functionName;
        Frame next;
        Frame(String name, Frame next) { 
            this.functionName = name; 
            this.next = next; 
        }
    }
    
    private Frame top = null;

    void push(String functionName) {
        top = new Frame(functionName, top);
    }

    String pop() {
        if (isEmpty()) throw new RuntimeException("No active call to return from");
        String name = top.functionName;
        top = top.next;
        return name;
    }

    String peek() {
        if (isEmpty()) throw new RuntimeException("No active call to peek");
        return top.functionName;
    }

    boolean isEmpty() { 
        return top == null; 
    }
}
