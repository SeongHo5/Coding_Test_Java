import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] userId, String[] bannedId) {
        Set<Set<String>> resultSets = new HashSet<>();
        matchUser(0, userId, bannedId, new HashSet<>(), resultSets);
        return resultSets.size();
    }

    private void matchUser(int index, String[] userId, String[] bannedId, Set<String> currentSet, Set<Set<String>> resultSets) {
        if (index == bannedId.length) {
            resultSets.add(new HashSet<>(currentSet));
            return;
        }

        String pattern = bannedId[index].replace("*", ".");
        for (String user : userId) {
            if (user.matches(pattern) && !currentSet.contains(user)) {
                currentSet.add(user);
                matchUser(index + 1, userId, bannedId, currentSet, resultSets);
                currentSet.remove(user);
            }
        }
    }
}