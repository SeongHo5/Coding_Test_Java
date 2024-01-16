import java.util.*;

class Solution {
            public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftIndex = new HashMap<>();
        Map<String, Map<String, Integer>> history = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (String f : friends) {
            history.put(f, new HashMap<>());
            giftIndex.put(f, 0);
            result.put(f, 0);
        }

        for (int i = 0; i < friends.length; i++) {
            Map<String, Integer> historyDetail = history.get(friends[i]);

            for (int j = 0; j < friends.length; j++) {
                if (i == j) {
                    continue;
                }
                historyDetail.put(friends[j], 0);
            }
        }

        // 선물 지수 초기화
        for (String gift : gifts) {
            String[] infos = gift.split(" ");
            String giver = infos[0];
            String receiver = infos[1];

            giftIndex.put(giver, giftIndex.getOrDefault(giver, 0) + 1);
            giftIndex.put(receiver, giftIndex.getOrDefault(receiver, 0) - 1);

            Map<String, Integer> takersMap = history.get(giver);
            takersMap.put(receiver, takersMap.getOrDefault(receiver, 0) + 1);
        }

        for (int i = 0; i < friends.length - 1; i++) {
            String giver = friends[i];
            Map<String, Integer> historyDetail = history.get(giver);

            for (int j = i + 1; j < friends.length; j++) {
                String receiver = friends[j];
                Map<String, Integer> takersInfoByTaker = history.get(receiver);

                int giftsGiven = historyDetail.get(receiver);
                int giftsReceived = takersInfoByTaker.get(giver);

                if (giftsGiven > giftsReceived) {
                    result.put(giver, result.getOrDefault(giver, 0) + 1);
                } else if (giftsGiven < giftsReceived) {
                    result.put(receiver, result.getOrDefault(receiver, 0) + 1);
                } else {
                    // 동점인 경우
                    int giverGiftPoint = giftIndex.get(giver);
                    int takerGiftPoint = giftIndex.get(receiver);

                    if (giverGiftPoint > takerGiftPoint) {
                        result.put(giver, result.getOrDefault(giver, 0) + 1);
                    } else if (giverGiftPoint < takerGiftPoint) {
                        result.put(receiver, result.getOrDefault(receiver, 0) + 1);
                    } else {
                        // 동점인 경우 아무도 선물을 받지 않음
                    }
                }
            }
        }
        int maxGifts = 0;
        for (int value : result.values()) {
            maxGifts = Math.max(maxGifts, value);
        }
        return maxGifts;
    }
}