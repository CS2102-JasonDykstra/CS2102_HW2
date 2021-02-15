import java.util.LinkedList;

public class Tournament{

    LinkedList<IWinner> rounds;

    public Tournament(LinkedList<IWinner> rounds) {
        this.rounds = rounds;
    }

    //finalWinnerIsValid: takes in a contestant representing the tournament winner and checks whether that contestant is a valid winner.
    // A contestant is a valid winner if he or she has won at least half of the rounds in the tournament.
    // Use the isWinner() methods in InitRound and AdvancedRound and the IWinner interface to solve this problem.

    public boolean finalWinnerIsValid(IContestant winner) {
        double roundCount = 0;
        double winCount = 0;

        for(IWinner r : rounds) {
            roundCount ++;
            if (r.isWinner(winner))
                winCount++;
        }
        return winCount >= (roundCount/2);

    }

}
