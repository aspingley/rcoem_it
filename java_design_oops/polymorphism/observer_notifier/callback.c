#include "stdio.h"

void callback(int i){
    printf("value = %d\n", i);
}

int main(){
    void (*fun_ptr)(int) = &callback; 
    for (int i=1; i<=10;i++){
        (*fun_ptr)(i);
    }
    return 0;
}