class Solution {
    public boolean hasCycle(ListNode hd) {
        if (hd == null || hd.next == null) return false;

        ListNode sl = hd;
        ListNode ft = hd.next;

        while (sl != ft) {
            if (ft == null || ft.next == null) return false;
            sl = sl.next;
            ft = ft.next.next;
        }

        return true;
    }
}
