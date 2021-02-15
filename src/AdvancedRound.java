import java.util.LinkedList;

public class AdvancedRound extends AbsRound implements IWinner{

    LinkedList<IContestant> contestants;

    public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> contestants) {
        super(matches);
        this.contestants = contestants;
    }

    //isWinner: IContestant -> returns whether that contestant was one of the winners from the previous round.
    public boolean isWinner(IContestant winner){

        for(IContestant c : contestants) {
            if(winner.equals(c))
                return true;
        }
        return false;
    }

}
