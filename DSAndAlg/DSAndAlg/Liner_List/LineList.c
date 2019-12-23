//
//  LineList.c
//  DSAndAlg
//
//  Created by YmWw on 2019/11/4.
//  Copyright © 2019 com.aso.task. All rights reserved.
//

#include "LineList.h"
#include <stdlib.h>

#define LIST_INIT_SZIE 2
#define LIST_INCREMENT_SZIE 10


// 初始化一个线性表
int initList(SqList *l){
    
    l -> elem = (int *)malloc(LIST_INIT_SZIE * sizeof(int));
    
    if (! l -> elem) {
        exit(0);
    }
    
    l -> length = 0;
    l -> size = LIST_INIT_SZIE;
    
    return 1;
}


// 在某个位置插入一个数值
int lineInsert(SqList *l, int position, int number) {
    
    if (position < 0 || position > l -> length + 1) {
        return -1;
    }
    
    if (l -> length >= l -> size) {
        
        int *newBase = (int *) realloc(l -> elem, (LIST_INCREMENT_SZIE + l -> size) * sizeof(int));
        if (!newBase) {
            return -1;
        }
        l -> elem = newBase;
        
        l -> size += LIST_INCREMENT_SZIE;
    }
    
    int *q = & (l -> elem[position]);
    
    for (int *pi = &(l -> elem[ l -> length - 1]);  pi >= q; pi--) {
       
        *(pi + 1) = *pi;
    }
    
    *q = number;
    
    l->length++;
    
    return 0;
}

int lineDeleteAtIndex(SqList *l, int position, int *value){
    
    if (position < 0 || position > l -> length - 1) {
        
        return -1;
    }
    
    int *p = &(l -> elem[position]);
    *value = *p;
    
    for (int * q = p; q < &(l -> elem [ l -> length - 1]); q++) {
        *q = *(q + 1);
    }
    
    l -> length -= 1;
    
    if (l -> size - l ->length >= LIST_INCREMENT_SZIE) {
        
        int *newBase = (int *) realloc(l -> elem, (l -> size - LIST_INCREMENT_SZIE) * sizeof(int));
        if (newBase) {
            
            l -> elem = newBase;
            l -> size -= LIST_INCREMENT_SZIE;
        }
    }
    
    
    return 0;
}


void printLine(SqList *l) {
    
    printf("size = %d  ", l -> size);
    printf("lenght = %d  ", l -> length);
    for (int i = 0; i < l ->length ; i++) {
        
        printf("%d ", l ->elem[i]);
    }
    
    printf("\n");
}





//测试代码

//SqList l;
//int status = initList(&l);
//printLine(&l);
//lineInsert(&l, 0, 100);
//printLine(&l);
//lineInsert(&l, 0, 200);
//lineInsert(&l, 0, 300);
//printLine(&l);
//lineInsert(&l, 1, 250);
//printLine(&l);
//lineInsert(&l, l.length, 90);
//printLine(&l);
