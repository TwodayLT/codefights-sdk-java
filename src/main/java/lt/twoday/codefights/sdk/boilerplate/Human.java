package lt.twoday.codefights.sdk.boilerplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

import lt.twoday.codefights.sdk.model.Move;
import lt.twoday.codefights.sdk.boilerplate.server.Protocol;
import lt.twoday.codefights.sdk.model.IFighter;


public class Human implements IFighter {
	private PrintStream consoleOut = System.out;
	private BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

	public Move makeNextMove(Move oppMove, int iScored, int oppScored) {
		printInstructions();

		while (true)
			try {
				Move move = parseInput(consoleIn.readLine().trim());
				return move;
			} catch (IllegalArgumentException ipe) {
				System.err.println("Human error: " + ipe.getMessage());
			} catch (Exception oce) {
				System.err.println("Bye");
				System.exit(0);
			}
	}

	private void printInstructions() {
		consoleOut.print("Make your move by (A)ttacking and (B)locking (N)ose, (J)aw, (B)elly, (G)roin, (L)egs (for example, BN BB AN): ");
	}

	private Move parseInput(String input) throws Exception {
		input = input.replace("\\W", "").toLowerCase();

		if (input.startsWith("q"))
			throw new Exception("Exiting");

		Move move = Protocol.parseMove(input);
		if (move.getAttacks().size() + move.getBlocks().size() > 3)
			throw new IllegalArgumentException(
					"Can make max 3 things at a time!");

		return move;
	}

}
