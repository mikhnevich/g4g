package dp;

/*
http://giocc.com/a-dynamic-programming-solution-to-the-josephus-problem.html

During the siege of Yodfat, Josephus was trapped in a cave with forty other soldiers while Roman soldiers waited
 outside. Instead of submitting to the Romans, they decided to commit suicide starting with every third man. In
 the end, Josephus and another man were the last men standing. Through some coercion, Josephus was able to prevent
 the morbid game from continuing at that point. Thus, they surrendered to the Romans, escaping death!
 */
public class Josephus {

    public static int nextMan(int currentToKill, int killStep, int population) {
        return (currentToKill + killStep) % population;
    }

    public static int findLastManStanding(int population, int killStep) {
        int[] manToKill = new int[population + 1];
        manToKill[0] = nextMan(0, killStep, population);

        for (int i = 1; i <= population; i++)
            manToKill[i] = nextMan(manToKill[i - 1], killStep, population);

        return nextMan(manToKill[population], killStep, population);
    }
}
