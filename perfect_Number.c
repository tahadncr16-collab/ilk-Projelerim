#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int number,i,sum;
    sum=0;
    printf("Enter a number:\n ");
    scanf("%d",&number);
    if (number==0||number<0) {
        printf("you can't enter zero and negative number\n");
        return 0;
    }
    for (i=1;i<=number/2;i++) {
        if (number%i==0) {
            sum=sum+i;
        }
    }
    if (sum==number) {
        printf("your number is perfect number");
    }
    else {
        printf("your number is not perfect");
    }
    return 0 ;
}



