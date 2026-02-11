#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float fahrenaytTranslate();
float celsiyusTranslate();
float kelvinTranslate();
int number,times,number2;
float derece,sonuc;
int main() {

    printf("Hangi derece turunu kullaniyorsunuz ?\n");
    printf("fahrenayt icin :1\n");
    printf("celsiyus icin :2\n");
    printf("kelvin icin :3\n");
    printf("giriniz:\n");
    scanf("%d",&number);
    printf("cevirmek istediginiz sicakligin derecesini giriniz\n");
    printf("sicakligi giriniz:\n");
    scanf("%f",&derece);
    printf("Elinizde ki sicaklik degerini hangi degere donusturmek istiyorsunuz ? ekranda ki degerleri giriniz\n ");
    printf("fahrenayt icin 4:\n");
    printf("celsiyus icin 5:\n");
    printf("kelvin icin 6:\n");
    printf("giriniz:\n");
    scanf("%d",&number2);
    if (number==1&&number2==5) {
        fahrenaytTranslate();
    }
    if (number==1&&number2==6) {
        fahrenaytTranslate();
    }
    if (number==2&&number2==4) {
        celsiyusTranslate();
    }
    if (number==2&&number2==6) {
        celsiyusTranslate();
    }
    if (number==3&&number2==4) {
        kelvinTranslate();
    }
    if (number==3&&number2==5) {
        kelvinTranslate();
    }


        return 0;
    }
float fahrenaytTranslate() {
    if (number==1&&number2==5) {
        sonuc=(derece-32)*5/9;
        printf("fahrenaytin celsiyus karsiligi: %.2f",sonuc);
    }
    else if (number==1&&number2==6) {
        sonuc=(derece-32)/1.8+273.15;
        printf("fahrenaytin kelvin karsiligi:%.2f",sonuc);
    }
    else {
        printf("lutfen gecerli bir deger giriniz");
        return 0;
    }
 }
float celsiyusTranslate() {
    if (number==2&&number2==4) {
        sonuc=(derece*9/5)+32;
       printf("celsiyusun fahrenayt karsikligi: %.2f",sonuc);
    }
    else if (number==2&&number2==6) {
        sonuc=derece+273;
        printf("celsiyusun kelvin karsikligi: %.2f",sonuc);
    }
    else {
        printf("lutfen gecerli bir deger giriniz");
        return 0;
    }
}
float kelvinTranslate() {
    if (number==3&&number2==4) {
        sonuc=((derece-273)*1.8)+32;
        printf("kelvinin fahrenayt karsiligi: %.2f",sonuc);
    }
    else if (number==3&&number2==5) {
        sonuc=derece-273;
        printf("kelvinin celsiyus karsiligi: %.2f",sonuc);
    }
    else {
        printf("lutfen gecerli bir deger giriniz");
        return 0;
    }
}