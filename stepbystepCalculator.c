#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void takeSquare(float number1 , float number2);
void maxValue(float number1, float number2  );
void minValue(float number1, float number2  );
void absoluteValue(float number1, float number2  );
int main() {
float number1,number2;
    int times;
    int operationNumber;
    printf("enter a number 1\n ");
    scanf("%f", &number1);
    printf("enter a number 2\n ");
    scanf("%f", &number2);
    printf("please wait..........\n");
    for (int i=1;i<=50000;i++) {
        for (int j=1;j<=50000;j++) {
            times=i*j;
        }
    }
    printf("please enter the operation number\n");
    printf("take square=1\n");
    printf("calculation max value:2\n");
    printf("calculation min value:3\n");
    printf("calculation absolute value:4\n");
    scanf("%d", &operationNumber);
    switch (operationNumber) {
        case 1: takeSquare(number1,number2); break;
        case 2: maxValue(number1,number2);break;
        case 3: minValue(number1,number2); break;
        case 4: absoluteValue(number1,number2); break;
    }
    return 0 ;
}
void takeSquare(float number1 , float number2) {
    float square1,square2;
    square1=number1*number1; square2=number2*number2;
    printf("the square is %.2f\n",square1);
    printf("the square is %.2f\n",square2);

}
void maxValue(float number1,float number2) {
    float sum1;
    sum1=0;
    if (number1<0&&number2<0) {
        if (number1<number2) {
            sum1=number2-number1;
            printf("the max is %.2f\n",sum1);
        }
        if (number2>number1) {
            sum1=number1-number2;
            printf("the max is %.2f\n",sum1);
        }

    }
    if (number1>0&&number2>0) {
        sum1=number1+number2;
        printf("the max is %.2f\n",sum1);
    }
    if (number1>0&&number2<0) {
        sum1=number1-number2;
        printf("the max is %.2f\n",sum1);
    }
    if (number1<0&&number2>0) {
        sum1=number2-number1;
        printf("the max is %.2f\n",sum1);
    }
    if (number1==number2) {
        printf("the max is %.2f\n",sum1);
    }

}
void minValue(float number1 , float number2) {
    float sum2;
    if (number1>number2) {
        sum2=number2-number1;
        printf("the min value is %.2f\n",sum2);
    }
    else {
        sum2 = number1-number2;
        printf("the min value is %.2f\n",sum2);
    }
}
void absoluteValue(float number1 ,float number2) {
    float absoluteSum;
    if (number1+number2<0) {
        if (number1<number2) {
            absoluteSum=number2-number1;
            printf("the absolute value is %.2f\n",absoluteSum);
        }
        else {
            absoluteSum=number1-number2;
            printf("the absolute value is %.2f\n",absoluteSum);
        }
    }
    if (number1+number2>0) {//13 9
        if(number1>number2) {
            absoluteSum=number1-number2;
            printf("the absolute value is %.2f\n",absoluteSum);
        }
       if (number2>number1) {
           absoluteSum=number2-number1;
           printf("the absolute value is %.2f\n",absoluteSum);
       }
    }
    if (number1+number2==0) {
        absoluteSum=0;
        printf("the absolute value is %.2f\n",absoluteSum);
    }

}