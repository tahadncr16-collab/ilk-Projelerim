#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int i,j,k,number;
    printf("enter a number:\n");
    scanf("%d",&number);

    for (i=1;i<=number;i++) {
        for (j=1;j<=number-i;j++) {
            printf(" ");
        }
        for (k=1;k<=i;k++) {
            if (i==number) {
                break;
            }
            printf("* ");
        }
        if (i==number) {
            break;
        }
        printf("\n");
    }
    for (i=number;i>=1;i--) {
        for (j=1;j<=number-i;j++) {
            printf(" ");
        }
        for (k=1;k<=i;k++) {
            printf("* ");
        }
        printf("\n");

    }
    return 0 ;
}



