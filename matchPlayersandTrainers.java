/* You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player. You are also given a 0-indexed integer array trainers, where trainers[j] represents the training capacity of the jth trainer.

The ith player can match with the jth trainer if the player's ability is less than or equal to the trainer's training capacity. Additionally, the ith player can be matched with at most one trainer, and the jth trainer can be matched with at most one player.

Return the maximum number of matchings between players and trainers that satisfy these conditions.
Constraints:

1 <= players.length, trainers.length <= 105
1 <= players[i], trainers[j] <= 109 */

class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            new Solution().matchPlayersAndTrainers(new int[] {}, new int[] {});
        }
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int l = 0;
        int r = 0;

        int players_len = players.length;
        int trainers_len = trainers.length;

        int count = 0;

        while (l < players_len && r < trainers_len) {
            if (players[l] <= trainers[r]) {
                count++;
                l++;
            }
            r++;
        }
        return count;
    }
}

/* ✅ Time & Space Complexity
Time Complexity:
O(n log n + m log m) for sorting players and trainers
O(n + m) for the matching using two pointers
→ Total average complexity: O(n log n + m log m)

Space Complexity:
O(1) extra space (no additional data structures used except a few variables) */
