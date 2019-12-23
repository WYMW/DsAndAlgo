//
//  main.c
//  DSAndAlg
//
//  Created by YmWw on 2019/11/4.
//  Copyright © 2019 com.aso.task. All rights reserved.
//

#include <stdio.h>
#include "LineList.h"
#include "LinkList.h"



int main(int argc, const char * argv[]) {
    // insert code here...
    int a[10] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    LinkList *header = createLinkList(a, sizeof(a) / sizeof(a[0]));

    printLinkList(header);
    
}
