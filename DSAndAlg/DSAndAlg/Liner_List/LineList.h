//
//  LineList.h
//  DSAndAlg
//
//  Created by YmWw on 2019/11/4.
//  Copyright © 2019 com.aso.task. All rights reserved.
//

#ifndef LineList_h
#define LineList_h
typedef struct {
    
    int *elem;
    int length;
    int size;
    
}SqList;

#include <stdio.h>
int initList(SqList *l);
int lineInsert(SqList *l, int position, int number);
int lineDeleteAtIndex(SqList *l, int position, int *value);
void printLine(SqList *l);
#endif /* LineList_h */
