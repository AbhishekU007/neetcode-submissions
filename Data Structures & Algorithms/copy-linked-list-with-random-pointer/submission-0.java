class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> orgToCopy = new HashMap<>();
        orgToCopy.put(null, null);

        Node curr = head;
        while(curr != null){
            if(!orgToCopy.containsKey(curr)){
                orgToCopy.put(curr, new Node(0));
            }
            orgToCopy.get(curr).val = curr.val;

            if(!orgToCopy.containsKey(curr.next)){
                orgToCopy.put(curr.next, new Node(0));
            }
            orgToCopy.get(curr).next = orgToCopy.get(curr.next);

            if(!orgToCopy.containsKey(curr.random)){
                orgToCopy.put(curr.random, new Node(0));
            }
            orgToCopy.get(curr).random = orgToCopy.get(curr.random);
            curr = curr.next;
        }
        return orgToCopy.get(head);
    }
}
