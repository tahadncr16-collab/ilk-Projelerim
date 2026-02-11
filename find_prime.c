int main() {
    int i,number;
    int checkPrime=1;
    printf("Enter a number\n");
    scanf("%d",&number);
    if (number<=1) {
        checkPrime=0;
    }
    else {
        for (i=2;i<=number/2;i++) {
            if (number%i==0) {
                checkPrime=0;
                break;
            }
        }
    }
    if (checkPrime==1) {
        printf("Your number is a prime number");
    }
    else {
        printf("Your number is not a prime number");
    }
    return 0;
}