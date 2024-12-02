class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = attacks[attacks.length-1][0];
        int life = health;
        int attackIdx = 0; // 공격 인덱스
        int heal = 0;
        
        for (int i = 1; i <= time; i++){
            if (i != attacks[attackIdx][0]){ // 공격 X
                life += bandage[1];
                heal++;
                if (heal == bandage[0]){ // 추가 회복
                    life += bandage[2];
                    heal = 0;
                }
                if (life > health) life = health; // 최대 체력 초과
            } else { // 공격 O
                heal = 0;
                life -= attacks[attackIdx][1];
                attackIdx++;
                if (life <= 0) return -1;
            }
        }
        return life;
    }
}
