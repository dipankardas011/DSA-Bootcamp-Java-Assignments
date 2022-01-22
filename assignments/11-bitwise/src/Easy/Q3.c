#include <stdio.h>
#include <stdlib.h>

uint32_t reverseBits(uint32_t n) {
    uint32_t m = 0;
    for (int i = 0; i < 32; i++) {
        m = m << 1;
        m |= n & 1;
        n =n >> 1;
    }
    return m;
}

int main(int argc, char **argv) {
    
    remove(argv[0]);
    return EXIT_SUCCESS;
}