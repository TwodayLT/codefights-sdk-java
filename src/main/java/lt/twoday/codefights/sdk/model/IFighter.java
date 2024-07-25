package lt.twoday.codefights.sdk.model;

public interface IFighter {
	
	Move makeNextMove(Move opponentsLastMove, int myLastScore, int opponentsLastScore);

}
