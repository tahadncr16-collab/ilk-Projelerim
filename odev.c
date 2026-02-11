#include <stdio.h>

int main() {
    int number,i,j,space;
    printf("enter a number:\n");
    scanf("%d",&number);
    for (i=1;i<=number;i++) {
        for (space = 1; space <= number - i; space++) {
            printf(" ");
        }
        for (j=1;j<=2*i-1;j++) {
           if (j==1||j==2*i-1) {
               printf("%d",i);
           }
            else {
                printf(" ");
            }
        }
        printf("\n");
    }
    for (i=number;i>=1;i--) {
        for (space = 1; space <= number - i; space++) {
            printf(" ");
        }
        for (j=1;j<=2*i-1;j++) {
            if (j==1||j==2*i-1) {
                printf("%d",i);
            }
            else {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}
