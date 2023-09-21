class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        // a와 b의 대소관계가 정해져있지 않으므로 a가 b보다 크다면 두 값을 바꿔준다
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
}