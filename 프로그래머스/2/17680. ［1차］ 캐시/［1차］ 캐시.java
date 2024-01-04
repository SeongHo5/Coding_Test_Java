import java.util.LinkedList;

class Solution {
        public int solution(int cacheSize, String[] cities) {
        // 캐시 크기가 0인 경우 = 도시 수 * 5
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        // 그 외
        int runTime = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();

            // Hit
            if (cache.remove(city)) {
                runTime += 1;
            } else {
                // Miss
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                runTime += 5;
            }
            cache.addLast(city);
        }
        return runTime;
    }
}