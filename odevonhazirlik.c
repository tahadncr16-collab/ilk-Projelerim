#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int x,i,k;
    x=0;
    printf("enter a number:\n ");
    scanf("%d",&x);
    for (i=1;i<=x;i++) {

        for (k=1;k<=i;k++) {
            printf("%d",k);
        }
        printf("\n");
    }
    for (i=1;i<=x;i++) {
        for (k=1;k<=x-i;k++) {
            printf("%d",k);
        }
        printf("\n");
    }
    return 0;
}
