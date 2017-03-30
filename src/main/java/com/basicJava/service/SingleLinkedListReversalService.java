package com.basicJava.service;

import com.basicJava.model.Node;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by zhouyifu on 2017/2/28.
 */

@Service
public class SingleLinkedListReversalService implements  ICommonService {

    /**
     * 相当于开始执行请求
     * @return
     */
    @Override
    public Map<String,Object> excuteTest() {
        Map<String,Object> res = new HashMap<String,Object>();


        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
//        res.put("原链表", h);

        Node newHead1 = this.Reverse1(head);
        res.put("递归法后的新链表",newHead1);

//不能同时解开注释，因为变量h
//        Node newHead2 = this.Reverse2(head);
//        res.put("递归法后的新链表", newHead2);


        return res;
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    private Node Reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }
    /**
     * 遍历，将当前节点的下一个节点缓存后更改当前节点指针
     */
    private  Node Reverse2(Node head) {
        if (head == null)
            return head;
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;
    }


}
