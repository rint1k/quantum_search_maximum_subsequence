package quantum_search_submax_lib.alg;

import quantum_search_submax_lib.util.Correct;

import java.util.Random;
/**
 * Класс, содержащий реализацию алгоритма Гровера.
 */
public class GroverAlgorithm {
    /**
     * Функция для поиска любого правильного индекса в диапазоне [lId, rId].
     *
     * @param correct объект класса, реализующий метод isCorrect(int), который принимает
     *                на вход индекс и возвращает 1, если индекс является правильным, и 0 в
     *                противном случае.
     * @param lId     левая граница диапазона поиска.
     * @param rId     правая граница диапазона поиска.
     * @return        любой правильный индекс в диапазоне [lId, rId], или -1, если такой
     *                индекс не найден.
     */
    static int findAnyCorrectIndex(Correct correct, int lId, int rId) {
        Random random = new Random();
        int sqrtN = (int) Math.sqrt(rId - lId + 1);
        int rand = -1;
        for (int i = 0; i < sqrtN; i++) {
            rand = random.nextInt(lId, rId);
            if (correct.isCorrect(rand) == 1) {
                return rand;
            }
        }
        return rand;
    }
}
