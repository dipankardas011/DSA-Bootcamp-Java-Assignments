#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* insertionSortList(struct ListNode* head){
    struct ListNode* p = head;
    struct ListNode* prev = head;
    struct ListNode* curr = head->next;
    while(curr){
        if(head->val > curr->val){
            prev->next = curr->next;
            curr->next = p;
            head = curr;
            curr = prev->next;
        }
        else{
            while(p->next && p->next->val < curr->val)
                p = p->next;
            if (prev->val > curr->val)
            {
                prev->next = curr->next;
                curr->next = p->next;
                p->next = curr;
                curr = prev->next;
            }
            else{
                // continue;
                prev = prev->next;
                curr = curr->next;
            }
        }
        p = head;
    }

    return head;
}

struct ListNode *createMem(int k) {
    struct ListNode *t = (struct ListNode *)malloc(sizeof(struct ListNode));
    t->val = k;
    t->next = 0;
    return t;
}

void display(struct ListNode *h) {
    if (!h) {
        printf("$!@?#\n");
        return ;
    }
    while (h) {
        printf("%d ",h->val);
        h = h->next;
    }
    printf("\n");
}

int main(int argc, char const *argv[])
{
    {
        //4,2,1,3
        struct ListNode *head = createMem(4);
        head->next = createMem(2);
        head->next->next = createMem(1);
        head->next->next->next = createMem(3);
        display(head);
        printf("Before insertion sort\n");
        head = insertionSortList(head);
        display(head);
    }
    remove(argv[0]);
    return 0;
}
