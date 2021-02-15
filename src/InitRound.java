import java.util.LinkedList;

public class InitRound extends AbsRound implements IWinner{

    public InitRound(LinkedList<Match> matches) {
        super(matches);
    }

    //isWinner: IContestant -> determines whether that contestant is a winner
    //by checking to see that the contestant was a winner in at least one of the matches that makes up that round.
    public boolean isWinner(IContestant winner){
        LinkedList<IContestant> low = this.getMatchWinners();

        for(IContestant c : low) {
            if(winner.equals(c))
                return true;
        }
        return false;
    }

}
