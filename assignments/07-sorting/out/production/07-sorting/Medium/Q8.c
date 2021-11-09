/**
 * Definition for singly-linked list.
 */
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* mergeIt(struct ListNode* a, struct ListNode* b) {
    struct ListNode* temp = NULL;

    if (a == NULL)// means that a is empty so insert reset of the b
        return b;

    if (b == NULL)
        return a;

    if (a->val < b->val) {
        // insert a
        temp = a;
        temp->next = mergeIt(a->next, b);
    } else {
        // insert b
        temp = b;
        temp->next = mergeIt(a, b->next);
    }

    return temp;
}

struct ListNode* getMid(struct ListNode* head) {
    struct ListNode* midPrev = NULL;
    while (head && head->next) {
        midPrev = (midPrev == NULL) ? head : midPrev->next;
        head = head->next->next;
    }
    struct ListNode* mid = midPrev->next;
    midPrev->next = NULL;
    return mid;
}

struct ListNode* sortList(struct ListNode* head){

    struct ListNode* a = NULL;
    struct ListNode* b = NULL;
    if (head== NULL || head->next == NULL) {
        return head;
    }

    struct ListNode *mid = getMid(head);

    a = sortList(head);
    b = sortList(mid);

    return mergeIt(a, b);
}

struct ListNode* createMemory(int key) {
    struct ListNode* t = (struct ListNode*)malloc(sizeof(struct ListNode));
    t->val = key;
    t->next = NULL;
    return t;
}

void display(struct ListNode* head) {
    assert(head!=NULL);
    do {
        printf("%d", head->val);
        head = head->next;
    } while (head && printf("->"));
}

int main(int argc, char** argv) {
    struct ListNode* head = NULL;
    /**
     * 4,2,1,3
     */
    head = createMemory(4);
    head->next = createMemory(2);
    head->next->next = createMemory(1);
    head->next->next->next = createMemory(3);

    display(head);

    head = sortList(head);
    printf("\n");
    display(head);
    remove(argv[0]);
    return 0;
}