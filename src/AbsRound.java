import java.util.LinkedList;

public abstract class AbsRound{

    LinkedList<Match> matches;

    public AbsRound(LinkedList<Match> matches) {
        this.matches = matches;
    }

    //getMatchWinners: returns a LinkedList of all of the contestants that won each match in each round.
    public LinkedList<IContestant> getMatchWinners(){
        LinkedList<IContestant> winners = new LinkedList<IContestant>();

        for(Match m : matches){
            winners.add(m.winner());
        }
        return winners;
    }

    //getNumWinners: returns the number of winners in the round.
    //use getMatchWinners().
    public int getNumWinners(){
        return this.getMatchWinners().size();
    }

}
