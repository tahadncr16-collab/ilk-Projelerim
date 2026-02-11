#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {

    int number,i,j;
    printf("enter a number:\n");
    scanf("%d",&number);
    for(i=1;i<=number;i++) {
        for (j=1;j<=i;j++) {
            printf("%d",i);
        }
        printf("\n");
    }
    for(i=number;i>=1;i--) {
        for (j=1;j<=i;j++) {
            printf("%d",i);
        }
        printf("\n");
    }

/*
    int number,i,j;
    printf("enter a number:\n");
    scanf("%d",&number);
    for(i=0;i<number;i++) {
        for (j=1;j<=number-i;j++) {
            printf("%d",i+1);
        }
        printf("\n");
    }
    /*
      int number,i,j;
      printf("enter a number:\n");
      scanf("%d",&number);
      for(i=1;i<=number;i++) {
          for (j=1;j<=number;j++) {
              printf("%d",i);
          }
          printf("\n");
      }
      */
    return 0 ;
}

