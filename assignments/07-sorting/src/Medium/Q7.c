/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* insertionSortList(struct ListNode* head){
    struct ListNode* iter = head;
    while (iter) {
        
        struct ListNode* node = iter;
        
        struct ListNode* kkk = head;

        while (kkk!=node && kkk->val > node->val) {
            kkk = kkk->next;
        }
        if (kkk == head) {
            // skip it
            iter = iter->next;
        }
        struct ListNode* prevNode = head;
        while (prevNode->next != node) 
            prevNode = prevNode->next;

        prevNode->next = node->next;
        node->next = kkk->next;
        kkk->next = node;

        iter = iter->next;
    }
}

