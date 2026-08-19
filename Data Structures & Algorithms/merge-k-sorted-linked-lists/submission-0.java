class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        for(ListNode i : lists){
            while(i != null){
                nodes.add(i.val);
                i = i.next;
            }
        }
        Collections.sort(nodes);

        ListNode result = new ListNode(0);
        ListNode cur = result;
        for(int node : nodes){
            cur.next = new ListNode(node);
            cur = cur.next;
        }
        return result.next;
    }
}
