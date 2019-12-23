//
//  LinkList.h
//  DSAndAlg
//
//  Created by YmWw on 2019/12/23.
//  Copyright © 2019 com.aso.task. All rights reserved.
//

#ifndef LinkList_h
#define LinkList_h

#include <stdio.h>
#include <stdlib.h>

typedef struct CLinkNode {
    int data;
    struct CLinkNode *next;
    int lenght;
}LinkNode;

typedef struct LinkList {
    LinkNode *header;
    int length;
}LinkList;


LinkList *createLinkList(int a[], int size);
void printLinkList(LinkList *linkList);

#endif /* LinkList_h */
