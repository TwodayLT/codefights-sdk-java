package lt.twoday.codefights.sdk;

import lt.twoday.codefights.sdk.model.Area;
import lt.twoday.codefights.sdk.model.IFighter;
import lt.twoday.codefights.sdk.model.Move;

/***
 * Add your fight logic to this class! That simple.
 *
 * @author urbonman
 *
 */
public class MyFighter implements IFighter {

    /***
     * create a NEXT move, based on your strategy.
     * You may keep track on opponent's behavior by accumulating
     *  fight's history in private state of this object (if you need it).
     *
     * Moves are made of up Attacks and Blocks, you can have up to 3 of them in one move.
     *
     * Attacks and Blocks can targeted either:
     * 	NOSE (10 pts)
     *  JAW  (8 pts)
     *  BELLY (6 pts)
     *  GROIN (4 pts)
     *  LEGS (3 pts).
     *
     * One Block voids all the attacks to that particular area.
     *
     * For example:
     *  You attack NOSE and LEGS, defending JAW.
     *  Opponent attacks your NOSE, JAW and JAW.
     *  ====
     *  Your score is 13 pts, while opponent scores only 10.
     */
    public Move makeNextMove(Move opponentsLastMove, int myLastScore, int opponentsLastScore) {

        if (opponentsLastMove == null) {
            return new Move().addAttack(Area.NOSE);
        }
        return opponentsLastMove;
    }
}

