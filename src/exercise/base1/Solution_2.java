package exercise.base1;

import java.util.List;

/**
 * @author sunLei on 2018/12/4 21:24
 * @version 1.0
 * @apiNote
 */
public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode node1=l1,node2=l2;
        ListNode head=new ListNode(0);
        ListNode currentNode=head;
        while (node1!=null || node2!=null){
            int num1=(node1==null)?0:node1.val;
            int num2=(node2==null)?0:node2.val;
            int sum=num1+num2+c;
            c=sum/10;
            currentNode.next=new ListNode(sum%10);
            currentNode=currentNode.next;
            if(node1!=null){node1=node1.next;}
            if(node2!=null){node2=node2.next;}
        }
        if(c>0){
            currentNode.next=new ListNode(c);
        }
        return head.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuilder val1=new StringBuilder();
        StringBuilder val2=new StringBuilder();
        //遍历两个链表
        ListNode node=l1;
        if(node!=null){
            val1.insert(0,node.val);
            while(node.next!=null){
                node=node.next;
                val1.insert(0,node.val);
            }
        }
        node=l2;
        if(node!=null){
            val2.insert(0,node.val);
            while(node.next!=null){
                node=node.next;
                val2.insert(0,node.val);
            }
        }
        ListNode head=new ListNode(0);
        ListNode nextNode=new ListNode(0);
        int result=Integer.parseInt(val1.toString())+Integer.parseInt(val2.toString());
        String s=String.valueOf(result);
        for(int i=s.length()-1;i>=0;i--){
            int val=Integer.parseInt(String.valueOf(s.indexOf(i)));
            ListNode newNode=new ListNode(val);
            if(i==0){
                head=newNode;
                newNode=head;
            }else{
                nextNode.next=newNode;
                nextNode=newNode;
            }
        }
        return head;
    }
}
