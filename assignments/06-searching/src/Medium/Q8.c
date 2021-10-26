int reachNumber(int target){
            int n = 0;
        int m = 0;
        target = abs(target);
        while(m<target){
            n++;
            m = (n*(n+1))/2;
        }
        while(m%2 != target%2){
            n++;
            m = (n*(n+1))/2;
        }
        return n;
}

int main(){
    reachNumber(...);
    return 0;
}