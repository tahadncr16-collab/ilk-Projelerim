#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main() {
    int i ;
    double  wheat=1;
    double  sumwheat=0;
    for (i=1;i<=64;i++) {
        printf("%d. kare icin bilgine verilecek bugday sayisi:%20.0f\n", i, wheat);
        sumwheat+=wheat;
        wheat*=2;
    }
    printf("\n bilgine verilecek toplam bugday sayisi:%20.0f\n", sumwheat);
    return 0;
}

