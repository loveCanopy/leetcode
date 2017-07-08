一种是按照原链表next的顺序依次创建节点，并处理好新链表的next指针，
同时把原节点与新节点的对应关系保存到一个hash_map中，
然后第二次循环将random指针处理好。这种方法的时间复杂度是O(n)，空间复杂度也是O(n)。
/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (!head) return NULL;
        unordered_map<RandomListNode*, RandomListNode*> mp;
        // 创建一个新的链表头
        RandomListNode *new_head = new RandomListNode(head->label);
        // node1负责指向原链表，node2负责指向新链表
        RandomListNode *node1 = head, *node2 = new_head;
        /**
         * 按照原链表的结构不断创建新的节点，并维护好next指针，将node1与node2的对应关系保存到hash_map中，
         * 以备后面维护random指针的时候，可以通过node1找到对应的node2。
         */
        while (node1->next != NULL) {
            mp[node1] = node2;
            node1 = node1->next;
            node2->next = new RandomListNode(node1->label);
            node2 = node2->next;
        }
        // 将两个链表的尾巴的对应关系也保存好
        mp[node1] = node2;
        
        // 继续从头开始处理random指针
        node1 = head;
        node2 = new_head;
        while (node1->next != NULL) {
            node2->random = mp[node1->random];
            node1 = node1->next;
            node2 = node2->next;
        }
        // 把尾巴的random指针也处理好
        node2->random = mp[node1->random];
        return new_head;
    }
};
第二种方法则是在原链表的每个节点之后插入一个新的节点，这样原节点与新节点的对应关系就已经明确了，因此不需要用hash_map保存，
但是需要第三次循环将整个链表拆分成两个。这种方法的时间复杂度是O(n)，空间复杂度是O(1)。
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head==NULL){
            return NULL;
        }

        RandomListNode *now = head;         //复制各个节点
        while(now){
            RandomListNode *copy = new RandomListNode(now->label);
            copy->next = now->next;
            now->next = copy;
            now = copy->next;
        }

        for(now=head; now; now=now->next->next){        //复制random指针域
            now->next->random = (now->random)?now->random->next:NULL;
        }

        RandomListNode* h = head->next;     //断开成两个链表
        RandomListNode* t = h;
        RandomListNode* tail = head;
        for(;;){              //t每次都在tail后俩个位置处
            tail->next = t->next;
            tail = tail->next;
            if(tail==NULL){
                break;
            }
            t->next = tail->next;
            t = t->next;
        }
        return h;
    }
};