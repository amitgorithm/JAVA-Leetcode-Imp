/* You are given an m x n grid classroom where a student volunteer is tasked with cleaning up litter scattered around the room. Each cell in the grid is one of the following:

'S': Starting position of the student
'L': Litter that must be collected (once collected, the cell becomes empty)
'R': Reset area that restores the student's energy to full capacity, regardless of their current energy level (can be used multiple times)
'X': Obstacle the student cannot pass through
'.': Empty space
You are also given an integer energy, representing the student's maximum energy capacity. The student starts with this energy from the starting position 'S'.

Each move to an adjacent cell (up, down, left, or right) costs 1 unit of energy. If the energy reaches 0, the student can only continue if they are on a reset area 'R', which resets the energy to its maximum capacity energy.

Return the minimum number of moves required to collect all litter items, or -1 if it's impossible. */

import java.util.*;

class Solution {
    static class State {
        int row, col, energy, steps, collected;

        State(int row, int col, int energy, int steps, int collected) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.steps = steps;
            this.collected = collected;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, energy, collected);
        }
    

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) return false;
            State other = (State) obj;
            return this.row == other.row && this.col == other.col &&
                   this.energy == other.energy && this.collected == other.collected;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] grid = new char[m][n];
        int totalLitter = 0;
        Map<String, Integer> litterIndex = new HashMap<>();
        int startRow = -1, startCol = -1;

        // Initialize grid and identify litter positions and starting point
        for (int i = 0; i < m; i++) {
            grid[i] = classroom[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L') {
                    litterIndex.put(i + "," + j, totalLitter++);
                } else if (grid[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int fullMask = (1 << totalLitter) - 1;
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        State startState = new State(startRow, startCol, energy, 0, 0);
        queue.offer(startState);
        visited.add(startState);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            // Check if all litter has been collected
            if (curr.collected == fullMask) {
                return curr.steps;
            }

            for (int d = 0; d < 4; d++) {
                int newRow = curr.row + dr[d];
                int newCol = curr.col + dc[d];
                int newEnergy = curr.energy - 1;
                int newCollected = curr.collected;

                // Check bounds
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;

                char cell = grid[newRow][newCol];
                if (cell == 'X') continue; // Obstacle

                // If energy is depleted and not on a reset cell, skip
                if (newEnergy < 0 && cell != 'R') continue;

                // Reset energy if on a reset cell
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Collect litter if present
                if (cell == 'L') {
                    String key = newRow + "," + newCol;
                    if (litterIndex.containsKey(key)) {
                        int idx = litterIndex.get(key);
                        newCollected |= (1 << idx);
                    }
                }

                State newState = new State(newRow, newCol, newEnergy, curr.steps + 1, newCollected);
                if (!visited.contains(newState)) {
                    visited.add(newState);
                    queue.offer(newState);
                }
            }
        }

        return -1; // Impossible to collect all litter
    }
}
