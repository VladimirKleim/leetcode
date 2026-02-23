package yandex_leetcode.src.main.java.temp;

public class MergeKSortedLists {
//    static class ListNode {
//        int val;
//        ListNode next;
//        public ListNode(){}
//        public ListNode(int val) {this.val = val;}
//        public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
//      public static ListNode mergeKSortedLists(ListNode[] lists) {
//          PriorityQueue<ListNode> pq = new PriorityQueue<>(
//                  (a,b) -> Integer.compare(a.val,b.val)
//          );
//          for(ListNode list : lists) {
//              if (list != null) {
//                  pq.add(list);
//              }
//          }
//          ListNode result = null;
//          ListNode resultEnd = null;
//          while(!pq.isEmpty()) {
//              ListNode smallest = pq.poll();
//              if (result == null) {
//                  result = smallest;
//              } else {
//                  resultEnd.next = smallest;
//              }
//              resultEnd = smallest;
//              if (smallest.next != null) {
//                  pq.add(smallest.next);
//              }
//          }
//        return result;
//      }
//    }
//
//
//
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null) {
//            return null;
//        }
//        PriorityQueue<ListNode> pq = new PriorityQueue<>(
//                (a,b) -> Integer.compare(a.val, b.val)
//        );
//        for (ListNode list : lists) {
//            if (list != null) {
//                pq.add(list);
//            }
//        }
//
//        ListNode result = null;
//        ListNode resultEnd = null;
//        if (!pq.isEmpty())  {
//            ListNode smallest = pq.poll();
//            if (result == null) {
//                result = smallest;
//            } else {
//                resultEnd.next = smallest;
//            }
//            resultEnd = smallest;
//            if (smallest.next != null) {
//                pq.add(smallest.next);
//            }
//        }
//        return result;
//    }
}
