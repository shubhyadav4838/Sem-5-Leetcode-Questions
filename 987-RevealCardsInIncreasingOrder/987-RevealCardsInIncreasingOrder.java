// Last updated: 3/8/2025, 11:56:05 pm
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!queue.isEmpty()) {
                queue.addFirst(queue.removeLast());
            }
            queue.addFirst(deck[i]);
        }
        int[] res = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            res[i] = queue.removeFirst();
        }
        return res;
    }
}