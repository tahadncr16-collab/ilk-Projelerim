#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void tensTranslate(int placeValue);
void hundredsTranslate(int placeValue);
void thousandsTranslate(int placeValue);
int number;
int main() {
    int division,mod;
printf("please enter a number:\n");
    scanf("%d",&number);
  division=number/1000;
    thousandsTranslate(division);
    mod=number%1000;
    number=mod;
   division=mod/100;
    hundredsTranslate(division);
   mod=number%100;
    division=mod/10;
    tensTranslate(division);
    return 0;
}
void thousandsTranslate(int placeValue) {
    switch (placeValue) {
        case 0: printf("zero\n"); break;
        case 1: printf("thousand\n"); break;
        case 2: printf("two thousand\n"); break;
        case 3: printf("three thousand\n"); break;
        case 4: printf("four thousand\n"); break;
        case 5: printf("five thousand \n"); break;
        case 6: printf("six thousand\n"); break;
        case 7: printf("seven thousand\n"); break;
        case 8: printf("eight thousand\n"); break;
        case 9: printf("nine thousand\n"); break;
    }
}
void hundredsTranslate(int placeValue) {
    switch (placeValue) {
        case 0: printf("zero \n"); break;
        case 1: printf("hundred\n"); break;
        case 2: printf("two hundred\n"); break;
        case 3: printf("three hundred\n"); break;
        case 4: printf("four hundred\n"); break;
        case 5: printf("five hundred\n"); break;
        case 6: printf("six hundred\n"); break;
        case 7: printf("seven hundred\n"); break;
        case 8: printf("eight hundred\n"); break;
        case 9: printf("nine hundred\n"); break;

    }
}
void tensTranslate(int placeValue) {
    switch (placeValue) {
        case 0: printf("ten\n"); break;
        case 1: printf("elewen\n"); break;
        case 2: printf("twelve\n"); break;
        case 3: printf("thirteen\n"); break;
        case 4: printf("fourteen\n"); break;
        case 5: printf("fiveteen\n"); break;
        case 6: printf("sixteen\n"); break;
        case 7: printf("seventeen\n"); break;
        case 8: printf("eighteen\n"); break;
        case 9: printf("nineteen\n"); break;
    }
}

