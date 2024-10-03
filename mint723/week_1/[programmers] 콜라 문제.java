class Solution {
    int a, b;
    public int solution(int a, int b, int n) {
        this.a = a;
        this.b = b;
        return cola(n, 0);
    }
    
    int cola(int n, int count){
        if(a>n) return count;
        return cola((n/a*b) + n%a, count + (n/a*b));
    }
}
