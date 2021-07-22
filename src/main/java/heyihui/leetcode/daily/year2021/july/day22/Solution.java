package heyihui.leetcode.daily.year2021.july.day22;

import heyihui.leetcode.common.Node;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 138. 复制带随机指针的链表
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            map.put(tmp, node);

            tmp = tmp.next;
        }

        Node vHead = new Node(-1);
        Node tmpRes = vHead;
        while(head != null) {
            Node node = map.get(head);
            node.next = map.get(head.next);
            node.random = map.get(head.random);

            tmpRes.next = node;
            tmpRes = node;

            head = head.next;
        }

        return vHead.next;
    }
}
