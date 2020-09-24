/* CleanBallotKarel.java
 * By: Jameson Squyres
 * 
 * This program will move across the world and check if the center 
 * of each ballot is empty, and if the center of a ballot is empty, 
 * any beepers will be removed from the ballot.
 */

import stanford.karel.*;

public class CleanBallotKarel extends SuperKarel {
	
	public void run() {				// While clear, move, check if the
		while(frontIsClear()) { 	// ballot should be cleaned,
			move();					// then move again.
			checkBallot();
			move();
		}
	}
	public void checkBallot() {		// If there is no beeper,
		if(noBeepersPresent()) {	// turn left to clean the top,
			turnLeft();				// clean the bottom, then turn
			cleanBallot();			// to face east again.
			cleanBallot();
			turnRight();
		}
	}
	public void cleanBallot() {		// Move, pick beepers until they
		move();						// are all gone, then turn around
		while(beepersPresent()) {	// and move again.
			pickBeeper();
		}
		turnAround();
		move();
	}
}