import java.util.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        final int DAYS_IN_MONTH = 28;
        final int MONTHS_IN_YEAR = 12;

        Map<String, Integer> termsMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        String[] todayParts = today.split("\\.");
        int currentYear = Integer.parseInt(todayParts[0]);
        int currentMonth = Integer.parseInt(todayParts[1]);
        int currentDay = Integer.parseInt(todayParts[2]);

        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termsMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            String[] dateParts = privacyParts[0].split("\\.");
            int privacyYear = Integer.parseInt(dateParts[0]);
            int privacyMonth = Integer.parseInt(dateParts[1]);
            int privacyDay = Integer.parseInt(dateParts[2]);

            int totalDaysFromPrivacy = (currentYear - privacyYear) * DAYS_IN_MONTH * MONTHS_IN_YEAR
                    + (currentMonth - privacyMonth) * DAYS_IN_MONTH
                    + (currentDay - privacyDay);

            int expirationDays = termsMap.get(privacyParts[1]) * DAYS_IN_MONTH;

            if (totalDaysFromPrivacy >= expirationDays) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}