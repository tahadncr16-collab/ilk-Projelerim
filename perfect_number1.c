#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int number,i,j,sum;
    sum=0;
    printf("Enter a number:\n ");
    scanf("%d",&number);
    if (number==0||number<0) {
        printf("you can't enter zero and negative number\n");
        return 0;
    }
    for (i=1;i<=number;i++) {
        sum=0;
        for (j=1;j<=i/2;j++) {
            if (i%j==0) {
                sum=sum+j;
            }
        }
        if (sum==i) {
            printf("%d\n",sum);
        }
    }
    return 0 ;
}