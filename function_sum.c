#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int sumNumber(int i);
int main() {
    int result=sumNumber(5);
    printf("result is:%d\n",result);
    return 0 ;
}
int sumNumber(int i) {
    if (i>0) {
        return i+sumNumber(i-1);
    }
    else {
        return 0;
    }
}