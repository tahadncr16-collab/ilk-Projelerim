#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int i,j,space,number;
    printf("Enter a number:\n");
    scanf("%d",&number);
    for(i=1;i<=number;i++) {
        for(space=1;space<=number-i;space++) {
            printf(" ");
        }
        for(j=1;j<=2*i-1;j++) {
            printf("*");
        }
        printf("\n");
    }
    return 0 ;
}

