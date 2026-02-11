#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int i,times,number;
    printf("Enter the number of times you want to enter:\n");
    scanf("%d",&number);
    times=1;
    for (i=1;i<=number;i++) {
        times=i*number;
    }
    printf("%d",times);
    return 0;
}
