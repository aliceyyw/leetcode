package structure;

/**
 * Created by wyy on 2/24/17.
 */
public class LinkedList {


    private ListNode head;
    public ListNode getHead() {return head;}


    public static ListNode initLinkedList(int[] init){
        if(init.length==0) return null;
        ListNode head;
        if(init.length==0) head=null;
        head = new ListNode(init[0]);
        ListNode pre = head;
        for(int i=1;i<init.length;i++){
            ListNode now = new ListNode(init[i]);
            pre.next=now;
            pre=now;
        }
        pre.next=null;
        return head;
    }

    public void printList(){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }

    public static void print(ListNode head){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }

    public ListNode deleteDuplicates(){
        //the linkedlist is already sorted
        if(head==null) return null;
        ListNode p = head;
        while(p.next!=null){
            if(p.val==p.next.val)
                p.next=p.next.next;
            else{
                p=p.next;
            }
        }
        return head;
    }
    // non-recursive way to merge sorted linkedlists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null&&l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode head=null;
        ListNode p1 =l1;
        ListNode p2 = l2;
        ListNode insert=null;

        if(l1.val<=l2.val){
            head = l1;
            p1=p1.next;
            insert=head;
        }
        else if(l1.val>l2.val){
            head=l2;
            p2=p2.next;
            insert=head;
        }
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                insert.next=p1;
                insert=insert.next;
                p1=p1.next;
            }else if(p1.val>=p2.val){
                insert.next=p2;
                insert=insert.next;
                p2=p2.next;
            }
        }
        if(p1==null&&p2!=null){
            while(p2!=null){
                insert.next=p2;
                insert=insert.next;
                p2=p2.next;
            }
        }
        else if(p1!=null&&p2==null){
            while(p1!=null){
                insert.next=p1;
                insert = insert.next;
                p1=p1.next;
            }
        }
        return head;
    }

    //leetcode_141 determine if the given linkedlist has a cycle
    public static boolean hasCycle(ListNode head){
        if(head==null) return false;
        ListNode less = head;
        ListNode  more = head.next;
        while(less!=null&more!=null){
            if(less==more)
                return true;
            less=less.next;
            more=more.next;
            if(more==null)
                break;
            else
                more=more.next;
        }
        return false;
    }

    //leetcode_234 whethere a linked list is palindrome
    public static boolean isPalindrome(ListNode head){
        if(head==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // the list after slow should be reversed ,then compare with that from head
        ListNode palind = reverseList(slow.next);
        ListNode q = head;
        while(palind!=null){
            if(palind.val!=q.val)
            return false;
            palind = palind.next;
            q=q.next;
        }
    return true;
    }
    // reverse a linked list and return the new head
    public static ListNode reverseList(ListNode head){
        ListNode cur,next;
        ListNode pre = null;
        cur = head;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //leetcode_203 remove all elements with given value in a linkedlist
    public static ListNode removeElements(ListNode head, int val){
        ListNode cur = head,pre = null,res=null;
        while(cur!=null){
            if(cur.val==val) {
                if(pre==null){
                    cur = cur.next;
                    continue;
                }
                pre.next = cur.next;
                cur = pre.next;
            }else{
                if(pre==null){
                    pre=cur;
                    res=cur;
                    cur=cur.next;
                    continue;
                }

                cur = cur.next;
                pre = pre.next;
            }
        }
        return res;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA==null||headB==null)
            return null;
        int lena = getLength(headA);
        int lenb = getLength(headB);
        ListNode trya = headA, tryb=headB;
        if(lena>lenb){
            while(lena!=lenb){
                trya=trya.next;
                lena--;
            }
        }
        if(lenb>lena){
            while(lenb!=lena){
                tryb=tryb.next;
                lenb--;
            }
        }
        while(trya!=null&&tryb!=null){
            if(trya==tryb)
                return trya;
            trya = trya.next;
            tryb = tryb.next;
        }
        return null;

    }
    // get the length of a linkedlist
    public int getLength(ListNode head){
        ListNode p = head;
        int count = 0;
        while(p!=null){
            p=p.next;
            count++;
        }
        return count;
    }
}
