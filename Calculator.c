#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void calculatorSum(float number1,float number2);
void calculatorSubtraction(float number1,float number2);
void calculatorTimes(float number1,float number2);
void calculatorDivision(float number1,float number2);
void calculatorMod(float number1,float number2);
void calculatorPower(float number1,float number2);
void calculatorSqrt(float number1);
void calculatorRootExtraction(float number1,float number2);
int main() {
    float number1,number2;
    char operation,exit;
    printf("\n========================================\n");
    printf("        SCIENTIFIC CALCULATOR\n");
    printf("========================================\n");
    printf(" Select an operation symbol below:\n\n");
    printf(" [+] Addition           (Sum)\n");
    printf(" [-] Subtraction        (Difference)\n");
    printf(" [x] Multiplication     (Product)\n");
    printf(" [/] Division           (Quotient)\n");
    printf(" [%%] Modulo             (Remainder)\n");
    printf(" [^] Power              (Exponentiation)\n");
    printf(" [S] Square Root        (sqrt(x))\n");
    printf(" [R] Root Extraction    (Nth Root)\n");
    printf("========================================\n");
    printf("Press Q or q to exit. Enter any other key to continue.\n");
    scanf("%c",&exit);
    if (exit=='q'&& exit=='Q') {
        return 0;
    }
    while (1) {
        printf("\nenter a number\n");
        scanf("%f", &number1);
        printf("Enter operation (+, -, x, /, %%, ^, S, R): \n");
        scanf(" %c",&operation);
        if (operation=='Q'||operation=='q') {
            break;
        }
        if (operation!='S'&& operation!='s') {
            printf("Enter the second number:\n ");
            scanf("%f", &number2);
        }
        printf("\nResult:\n");
        switch (operation) {
            case '+' : calculatorSum(number1, number2);
                break;
            case '-' : calculatorSubtraction(number1, number2);
                break;
            case 'X':
            case 'x':
            case '*':
                calculatorTimes(number1, number2);
                break;
            case '/':calculatorDivision(number1,number2);
                break;
            case '%':calculatorMod(number1,number2);
                break;
            case '^':
                calculatorPower(number1, number2);
                break;
            case 'S':
            case 's':
                calculatorSqrt(number1);
                break;
            case 'R':
            case 'r':
                calculatorRootExtraction(number1, number2);
                break;
            default:
                printf("Error: You entered an invalid operation character!");
        }
    }


        return 0;
    }
void calculatorSum(float number1,float number2) {
    float sum;
    sum=number1+number2;
    printf("sum=%.2f\n",sum);
}
void calculatorSubtraction(float number1,float number2) {
    float subtraction;
    subtraction=number1-number2;
    printf("subtraction=%.2f\n",subtraction);

}
void calculatorTimes(float number1,float number2) {
    float times;
    times=number1*number2;
    printf("times=%.2f\n",times);
}
void calculatorDivision(float number1,float number2) {
    float division;
    if (number2==0) {
        printf("please can't do this");
        return ;
    }
    division=number1/number2;
    printf("division=%.2f\n",division);
}
void calculatorMod(float number1,float number2) {
    float mod;
    if (number2==0) {
        printf("Error: Division by zero is not allowed.\n");
        return ;
    }
    mod= fmod(number1,number2);
    printf("mod=%.2f\n",mod);
}
void calculatorPower(float number1,float number2) {
    float power;
    power=pow(number1,number2);
    printf("power=%.2f\n",power);
}
void calculatorSqrt(float number1) {
    float squareRoot;
    if (number1<0) {
        printf("You cannot take the square root of a negative number.");
    }
    else {
        squareRoot=sqrt(number1);
        printf("squareRoot=%.2f\n",squareRoot);
    }
}

void calculatorRootExtraction(float number1,float number2) {
    float rootExtraction;
    if (number2==0) {
        printf("The degree of the root cannot be zero.");
        return ;
    }
    rootExtraction=pow(number1, 1.0/number2);
    printf("exponentiation=%.2f\n",rootExtraction);

}