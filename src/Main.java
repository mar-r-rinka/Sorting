import java.util.Arrays;

public class Main {
    static int[][] regionalTeams = {{45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
            {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
            {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}};

    public static void sortedTeams(int[][] regionalTeams) {
        for (int[] regionalTeam : regionalTeams) {
            Arrays.sort(regionalTeam);

        }
    }

    public static int[] completeNationalTeam(int[][] regionalTeams) {
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++) {
            team = merge(team, regionalTeams[i]);
        }
        return team;
    }

    public static int[] merge(int[] team, int[] regionalTeams) {
        int[] nationalTeam = new int[10];
        int iTeam = nationalTeam.length - 1;
        int iRegionalTeam = regionalTeams.length - 1;
        int iNationalTeam = nationalTeam.length - 1;
        while (iNationalTeam >= 0) {
            if (team[iTeam] >= regionalTeams[iRegionalTeam]) {
                nationalTeam[iNationalTeam] = team[iTeam];
                iTeam -= 1;
            } else {
                nationalTeam[iNationalTeam] = regionalTeams[iRegionalTeam];
                iRegionalTeam -= 1;
            }
            iNationalTeam -= 1;
        }
        return nationalTeam;
    }

    public static void main(String[] args) {
        sortedTeams(regionalTeams);
        int[] nationalTeam = completeNationalTeam(regionalTeams);

        for (int i = nationalTeam.length - 1; i > 0; i--) {
            System.out.print(nationalTeam[i] + ", ");
        }
        System.out.println(nationalTeam[0]);
    }
}