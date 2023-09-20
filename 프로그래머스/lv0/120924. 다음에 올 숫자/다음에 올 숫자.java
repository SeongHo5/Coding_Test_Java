class Solution {
    public int solution(int[] common) {
        
                if (common[1] - common[0] == common[common.length - 1] - common[common.length - 2]) {
        	int diff = common[1] - common[0];
            return common[common.length - 1] + diff;
        } else if (common[1] / common[0] == common[common.length - 1] / common[common.length - 2]) {
        	int ratio = common[1] / common[0];
            return common[common.length - 1] * ratio;
        }
        
        return -1;
    }
}