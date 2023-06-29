import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

/**
 * 8C
 *
 * @author artyom
 */
public class LookingForOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] parsedString = parsedString = in.readLine().split(" ");
        int xStart = parseInt(parsedString[0]);
        int yStart = parseInt(parsedString[1]);
        int objectNum = parseInt(in.readLine());

        int[] xLocs = new int[objectNum + 1];
        int[] yLocs = new int[objectNum + 1];
        int[] bitMasks = new int[1 << objectNum];
        Arrays.fill(bitMasks, MAX_VALUE);
        int[] previous = new int[1 << objectNum];

        xLocs[objectNum] = xStart;
        yLocs[objectNum] = yStart;
        for (int i = 0; i < objectNum; i++) {
            parsedString = in.readLine().split(" ");
            xLocs[i] = parseInt(parsedString[0]);
            yLocs[i] = parseInt(parsedString[1]);
        }

        //go through all pairs and find time requirement for each pair of objects
        //the entry at point [i][j] is equal to the time it takes to get from point i to point j
        int[][] times = new int[objectNum + 1][objectNum + 1];
        for (int i = 0; i <= objectNum; i++) {
            for (int j = 0; j <= objectNum; j++) {
                times[i][j] = times[j][i] = (xLocs[i] - xLocs[j]) * (xLocs[i] - xLocs[j]) + (yLocs[i] - yLocs[j]) * (yLocs[i] - yLocs[j]);
            }
        }

        //each value in bitmasks represents the minimum time necessary to get
        //the unmasked bits
        //so bitmasks[5] (5=101) is the fastest time in which you can get
        //items 1 and 3
        bitMasks[0] = 0; //collecting zero objects takes 0 time
        for (int i = 0; i < (1 << objectNum); i++) {
            if (bitMasks[i] != MAX_VALUE) {
                for (int j = 0; j < objectNum; j++) {
                    if (((1 << j) & i) == 0) { //if our current j object hasn't been picked up yet
                        int curState = (1 << j) | i; //ith state after picking up j object
                        int curTime = bitMasks[i] + 2 * times[objectNum][j]; //time required to get object j from bag at state i

                        if (curTime < bitMasks[curState]) {
                            bitMasks[curState] = curTime; //put fastest time in for gettingto our current state
                            previous[curState] = i;
                        }

                        //find another thing while you're out
                        for (int k = 0; k < objectNum; k++) {
                            if (((1 << k) & curState) == 0) { //if the kth position in our current state hasn't been picked up
                                int kState = ((1 << k) | curState); //curstate after picking up the kth object
                                //kTime is time it takes to go from bag, to j, to k and back
                                int kTime = bitMasks[i] + times[objectNum][j] + times[j][k] + times[k][objectNum];

                                if (kTime < bitMasks[kState]) {
                                    bitMasks[kState] = kTime;  //put shortest time for getting to kState in
                                    previous[kState] = i;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }

        int finalState = (1 << objectNum) - 1;

        StringBuilder sb = new StringBuilder();
        sb.append(bitMasks[finalState]).append('\n');

        Deque<Integer> outputQ = new ArrayDeque<>();
        outputQ.add(0);
        int curState = finalState;
        while (curState > 0) {
            //difference is the objects picked up in this state but not in previous state
            int difference = curState ^ previous[curState];
            int firstItem = -1;
            int secondItem = -1;

            for (int i = 0; i < objectNum; i++) {
                if (((1 << i) & difference) > 0) { //if the ith object was picked up in this state
                    secondItem = firstItem; //keep track of how many items are picked up
                    firstItem = i;
                }
            }

            if (secondItem != -1) {
                //put in two items followed by a return to 0
                outputQ.add(firstItem + 1);
                outputQ.add(secondItem + 1);
                outputQ.add(0);
            } else {
                outputQ.add(firstItem + 1);
                outputQ.add(0);
            }

            curState = previous[curState];
        }

        sb.append(outputQ.removeLast());
        while (!outputQ.isEmpty()) {
            sb.append(' ').append(outputQ.removeLast());
        }
        System.out.print(sb);
    }
}