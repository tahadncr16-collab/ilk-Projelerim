#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.14159265
void calculatorSum(float number1,float number2);
void calculatorSubtraction(float number1,float number2);
void calculatorTimes(float number1,float number2);
void calculatorDivision(float number1,float number2);
void calculatorMod(float number1,float number2);
void calculatorPower(float number1,float number2);
void calculatorSqrt(float number1);
void calculatorRootExtraction(float number1,float number2);
void calculatorSin(float number1);
void calculatorCos(float number1);
void calculatorTan(float number1);
void calculatorCot(float number1);
void calculatorArcCot(float number1);
void calculatorArcSin(float number1);
void calculatorArcCos(float number1) ;
void calculatorArcTan(float number1);
void calculatorLn(float number1);
void calculatorLog(float number1);
void calculatorLogBase(float number1, float number2);
int main() {
   float number1, number2;
    char operation, exitKey;

    printf("\n===========================================================\n");
    printf("                  SCIENTIFIC CALCULATOR                    \n");
    printf("===========================================================\n");
    printf(" [+] Sum             [-] Subtraction      [*] Multiplication\n");
    printf(" [/] Division        [%%] Modulo           [^] Power (x^y)\n");
    printf("-----------------------------------------------------------\n");
    printf(" [r] Square Root     [R] Nth Root (x^(1/y))\n");
    printf("-----------------------------------------------------------\n");
    printf(" [s] Sin             [c] Cos              [t] Tan\n");
    printf(" [o] Cot             [n] Ln (Base e)      [l] Log (Base 10)\n");
    printf("-----------------------------------------------------------\n");
    printf(" [S] ArcSin          [C] ArcCos           [T] ArcTan\n");
    printf(" [O] ArcCot          [L] Log Base x (log_x(y))\n");
    printf("===========================================================\n");

    // Çıkış kontrolünü döngü içine almak daha sağlıklıdır, aşağıya taşıdım.

    while (1) {
        printf("\nEnter operation symbol (or 'Q' to quit):\n ");
        scanf(" %c", &operation);

        if (operation == 'Q' || operation == 'q') {
            break;
        }

        printf("Enter the first number: ");
        scanf("%f", &number1);
        int isBinary = 0;//`isBinary` is a flag that checks if a second number is required.
        if (operation == '+' || operation == '-' || operation == '*' || operation == 'x' || operation == 'X' ||
            operation == '/' || operation == '%' || operation == '^' || operation == 'R' || operation == 'L') {
            isBinary = 1;//isBinary was the last one.
        }

        if (isBinary) {//isBinary works because the last one is 1.
            printf("Enter the second number: ");
            scanf("%f", &number2);
        }

        printf("\nResult -> ");
        switch (operation) {
            //  Basic Operations
            case '+': calculatorSum(number1, number2); break;
            case '-': calculatorSubtraction(number1, number2); break;
            case 'x':
            case 'X':
            case '*': calculatorTimes(number1, number2); break;
            case '/': calculatorDivision(number1, number2); break;
            case '%': calculatorMod(number1, number2); break;
            case '^': calculatorPower(number1, number2); break;

            // root operations
            case 'r':
                calculatorSqrt(number1);
                break;
            case 'R':
                calculatorRootExtraction(number1, number2);
                break;

            //  trigonometry (little letter)
            case 's': calculatorSin(number1); break;
            case 'c': calculatorCos(number1); break;
            case 't': calculatorTan(number1); break;
            case 'o': calculatorCot(number1); break;

            //  inverse trigonometry (large tetter)
            case 'S': calculatorArcSin(number1); break;
            case 'C': calculatorArcCos(number1); break;
            case 'T': calculatorArcTan(number1); break;
            case 'O': calculatorArcCot(number1); break;

            //  Log
            case 'n': calculatorLn(number1); break;
            case 'l': calculatorLog(number1); break;
            case 'L': calculatorLogBase(number1, number2); break; // 1: base, 2: power

            default:
                printf("Error: Invalid Operation '%c'\n", operation);
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
void calculatorSin(float number1) {
    float sinus;
    float radianValue = number1 * (PI / 180.0);
    sinus = sinf(radianValue );
    printf("sinus=%.2f\n",sinus);
}
void calculatorCos(float number1) {
    float cosinus;
    float radianValue = number1 * (PI / 180.0);
    cosinus=cosf(radianValue);
    printf("cosinus=%.2f\n",cosinus);
}
void calculatorTan(float number1) {
    float tanjant;
    float radianValue = number1 * (PI / 180.0);
    tanjant=tanf(radianValue);
    printf("tanjant=%.2f\n",tanjant);
}
void calculatorCot(float number1) {
    float tanjant, cotanjant;
    float radianValue = number1 * (PI / 180.0);
    tanjant = tanf(radianValue);
    if (fabs(tanjant) < 0.00001) {
        printf("Error: Cotangent is undefined (Division by zero) for %.2f degrees.\n", number1);
        return;
    }
    else {
        cotanjant = 1.0 / tanjant;
        printf("cotanjant=%.2f\n", cotanjant);
    }
}
void calculatorArcSin(float number1) {
    if (number1 < -1.0 || number1 > 1.0) {
        printf("Error: Input for ArcSin must be between -1 and 1.\n");
        return;
    }
    float radyan = asinf(number1);
    float derece = radyan * (180.0 / PI);
    printf("arcsin(%.2f) = %.2f degrees\n", number1, derece);
}
void calculatorArcCos(float number1) {
    if (number1 < -1.0 || number1 > 1.0) {
        printf("Error: Input for ArcCos must be between -1 and 1.\n");
        return;
    }
    float radyan = acosf(number1);
    float derece = radyan * (180.0 / PI);
    printf("arccos(%.2f) = %.2f degrees\n", number1, derece);
}
void calculatorArcTan(float number1) {
    float radyan = atanf(number1);
    float derece = radyan * (180.0 / PI);

    printf("arctan(%.2f) = %.2f degrees\n", number1, derece);
}
void calculatorArcCot(float number1) {
    float radyan = (PI / 2.0) - atanf(number1);
    float derece = radyan * (180.0 / PI);
    printf("arccot(%.2f) = %.2f degrees\n", number1, derece);
}
void calculatorLn(float number1) {
    if (number1 <= 0) {
        printf("Error: The Ln function is defined only for positive numbers (x > 0).\n");
    } else {
        float sonuc = logf(number1);
        printf("ln(%.2f) = %.2f\n", number1, sonuc);
    }
}
void calculatorLog(float number1) {
    if (number1 <= 0) {
        printf("Error: The Log function is defined only for positive numbers (x > 0).\n");
    } else {
        float result = log10f(number1);
        printf("log10(%.2f) = %.2f\n", number1, result);
    }
}
void calculatorLogBase(float number1, float number2) {//number1=base number2=pow
    if (number1<=0||number1==1) {
        printf("Error: The base of the logarithm must be positive and not 1.\n");
    }
    else if (number2<=0) {
        printf("Error: The number whose logarithm is being taken must be positive.\n");
    }
    else {
     float result;
        result=logf(number2)/logf(number1);
        printf("log_%.1f(%.1f) = %.2f\n", number1, number2,result);
    }
}