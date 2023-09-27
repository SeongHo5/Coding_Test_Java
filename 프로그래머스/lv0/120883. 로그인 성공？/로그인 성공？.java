class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pw = id_pw[1];

        boolean idMatched = false;
        boolean pwMatched = false;

        for (String[] account : db) {
            if (account[0].equals(id)) {
                idMatched = true;

                if (account[1].equals(pw)) {
                    pwMatched = true;
                    break;
                }
            }
        }

        if (idMatched) {
            if (pwMatched) {
                return "login";
            } else {
                return "wrong pw";
            }
        } else {
            return "fail";
        }
    }
}
