import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;
        int lightestPersonIndex = 0;
        int heviestPersonIndex = people.length - 1;

        while (lightestPersonIndex <= heviestPersonIndex) {
            if (people[lightestPersonIndex] + people[heviestPersonIndex] <= limit) {
                lightestPersonIndex++;
            }
            heviestPersonIndex--;
            boatCount++;
        }
        return boatCount;
    }
}