//
//  LinkList.c
//  DSAndAlg
//
//  Created by YmWw on 2019/12/23.
//  Copyright © 2019 com.aso.task. All rights reserved.
//

#include "LinkList.h"
LinkList *createLinkList(int a[], int size) {
    
    int length = 0;
    if (a == NULL) {
        return NULL;
    }
    
    LinkNode *header = NULL;
    LinkNode *before = NULL;
    for (int i = 0; i < size; i++) {
        
        LinkNode *node = (LinkNode *)malloc(sizeof(LinkNode));
        node -> data = a[i];
        node -> next = NULL;
        if (before) {
            before -> next = node;
        }
        before = node;
        if (header == NULL) {
            header = node;
        }
        length++;
    }
    
    LinkList *linkList = (LinkList *)malloc(sizeof(LinkList));
    linkList -> header = header;
    linkList -> length = length;
    
    return linkList;
}

void printLinkList(LinkList *linkList) {
    LinkNode *p = linkList -> header;
    printf("length = %d \n", linkList -> length);
    while (p != NULL) {
        printf("%d  ", p -> data);
        p = p -> next;
    }
}
