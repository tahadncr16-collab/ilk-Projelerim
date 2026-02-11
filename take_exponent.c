#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float exponentiation(float x,int y);//x=taban y=us
int main() {
    float base=0,result=0; //base=taban
    int exponent=0; // us
    printf("enter base and exponent  values\n");
    scanf("%f%d", &base,&exponent);
    result=exponentiation(base,exponent);
    printf("the result is %.2f\n",result);
    return 0 ;
}
float exponentiation (float x,int y) {
    float result=1;
    int i;
    if (y<0) {
        for (i=0;i<-y;i++) {
            result*=1/x;
        }
    }
    else {
        for (i=0;i<y;i++) {
            result*=x;
        }
    }
    return result;
}