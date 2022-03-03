package com.company;

import java.util.Arrays;
import java.util.*;

import static java.util.Arrays.sort;

class GetMissingNumber {
    public int findmissingnumber(int[] A) {
        long actualsum = 0;
        for (int i : A) {
            actualsum = actualsum + i;
        }
        long maxnumber = A.length + 1;
        long expectedsum = (maxnumber * (maxnumber + 1) / 2);
        return (int) (expectedsum - actualsum);
    }
}

class GetEquilibrium {
    public int FindEquilibrium(int[] A) {
        long leftsum = 0;
        long rightsum = 0;
        int RightTraverse = A.length;
        int LeftTraverse = 0;
        // leftsum =  A[LeftTraverse];
        //rightsum = A[RightTraverse-1];
        while ((RightTraverse > LeftTraverse)) {
            //   System.out.println(LeftTraverse);
            if (leftsum > rightsum) {
                rightsum = rightsum + A[RightTraverse - 1];
                RightTraverse = RightTraverse - 1;
            } else {
                leftsum = leftsum + A[LeftTraverse];
                LeftTraverse = LeftTraverse + 1;
            }
            //  System.out.println(leftsum);
        }
        return (int) (Math.abs(leftsum - rightsum));

    }

    public int Option2(int[] A) {
        int leftsum = 0;
        int rightsum = 0;
        for (int X : A) rightsum += X;

        int diff = Math.abs(leftsum - rightsum);
        for (int i = 1; i < A.length - 1; i++) {
            leftsum += A[i];
            rightsum -= A[i];
            int currentDiff = Math.abs(leftsum - rightsum);
            if (diff > currentDiff) diff = currentDiff;
        }
        return diff;
    }
}

class Arrayexamples {

    public String ArrayCyclicrotation(int[] A, int rotation) {
        int arraysize = A.length;
        int newindex = 0;
        int oldvalue = A[0];

        int IndextoChange = 0;
        int Oldindex = 0;
        newindex = getnewindex(arraysize, 0, rotation);
        int ValuetoReplace = A[0];
        do {
            oldvalue = A[newindex];
            A[newindex] = ValuetoReplace;
            ValuetoReplace = oldvalue;
            IndextoChange = newindex;
            newindex = getnewindex(arraysize, IndextoChange, rotation);
        } while (newindex > 0);
        A[0] = ValuetoReplace;


        return Arrays.toString(A);
        //return outString = outString + "}";

    }

    private int getnewindex(int ArraySize, int oldindex, int rotation) {
        int newindex = oldindex + rotation;
        if (newindex >= ArraySize) {
            newindex = newindex - ArraySize;
        }
        return (oldindex + rotation) % ArraySize;

        //return newindex;
    }

    ;


}

class maxcounter {
    public String Maxcounter(int A[], int Size) {
        int[] counter = new int[Size + 1];
        int maxcoun = 0;
        Arrays.fill(counter, maxcoun);
        for (int i = 0; i < A.length; i++) {
            try {
                counter[A[i]] += 1;
                if (counter[A[i]] > maxcoun) maxcoun = counter[A[i]];
            } catch (Exception e) {
                System.out.println(Arrays.toString(counter));
                Arrays.fill(counter, maxcoun);
            }
        }
        return Arrays.toString(counter);
    }
}

class StacksAndQueues {
    public String BracketsUsingStacks(String Brackets) {
        Stack<Character> bracketsStack = new Stack();
        char[] b = Brackets.toCharArray();
        for (int c = 0; c < b.length; c++) {
            if (b[c] == '{' || b[c] == '[' || b[c] == '(') {
                bracketsStack.push(b[c]);
            } else if (b[c] == '}' & (bracketsStack.peek() == '{')) {
                bracketsStack.pop();
            } else if (b[c] == ')' & (bracketsStack.peek() == '(')) {
                bracketsStack.pop();
            } else if (b[c] == ']' & (bracketsStack.peek() == '[')) {
                bracketsStack.pop();
            }
        }
        System.out.println(bracketsStack.toString());
        if (bracketsStack.isEmpty()) {
            return "Correct";
        } else {
            return "Wrong";
        }
    }

    // 0 is left to right and 1 is right to left
    public int Fishsurvivors(int Direction[], int Weight[]) {
        Stack<Integer> LeftToRightFishWeight = new Stack();
        int Survivor = 0;
        for (int f = 0; f < Direction.length; f++) {
            if (Direction[f] == 0) {
                LeftToRightFishWeight.push(Weight[f]);
            } else {
                boolean Rightisbigfish = true;
                do {
                    if (LeftToRightFishWeight.isEmpty()) {
                        Rightisbigfish = false;
                        Survivor += 1;
                    } else {
                        if (Weight[f] > LeftToRightFishWeight.peek()) {
                            LeftToRightFishWeight.pop();
                        } else {
                            Rightisbigfish = false;
                        }
                    }
                } while (Rightisbigfish);
            }
        }
        Survivor += LeftToRightFishWeight.size();

        return Survivor;

    }


    public int Dominator(int[] A) {
        int counter = 0;
        int Candidate = 0;
        for (int item : A) {
            if (counter == 0) {
                Candidate = item;
                counter += 1;
            } else if (Candidate == item) {
                counter += 1;
            } else {
                counter -= 1;
            }
        }
        counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == Candidate) {
                counter += 1;
            }
        }
        if (counter > A.length / 2) {
            return Candidate;
        } else {
            return -1;
        }
    }
}

class MaxProfit {

    public int getMaximumsum(int[] A) {

        int globalMaxSum = 0;
        int localMaxSum = 0;
        LinkedList<Integer> MaxlocalArray = new LinkedList();
        LinkedList<Integer> MaxGlobalArray = new LinkedList();
        for (int i = 1; i < A.length; i++) {
            int localSum = A[i] - A[i - 1];


            // localMaxSum = Math.max(localSum, localSum+localMaxSum );
            //globalMaxSum = Math.max(globalMaxSum,localMaxSum);


            if (localSum > localSum + localMaxSum) {
                localMaxSum = localSum;
                MaxlocalArray.clear();
                MaxlocalArray.add(A[i]);
            } else {
                localMaxSum = localSum + localMaxSum;
                MaxlocalArray.add(A[i]);
            }

            if (globalMaxSum > localMaxSum) {
                // localMaxSum = localSum;
            } else {
                globalMaxSum = localMaxSum;
                MaxGlobalArray = MaxlocalArray;
            }
        }
        System.out.println(MaxGlobalArray.toString());
        return globalMaxSum;
    }

}

class NumberofDiscIntersections {

    public int DiscLog(int A[]) {
        int ArraySize = A.length;

        DiscLog[] disclog = new DiscLog[ArraySize * 2];
        int j = -1;
        for (int i = 0; i < ArraySize; i++) {
            disclog[j = j + 1] = new DiscLog(i - (long) A[i], 1);
            disclog[j = j + 1] = new DiscLog(i + (long) A[i], -1);

        }

        sort(disclog);
        int TotaIntersections = 0;
        int activeIntersections = 0;

        for (DiscLog log : disclog) {
            activeIntersections += log.getStartandEndPosition();
            if (log.getStartandEndPosition() > 0) TotaIntersections += activeIntersections - 1;
            if (TotaIntersections > 10000000) return -1;
        }
        return TotaIntersections;
       /* System.out.println(Arrays.toString(A));
        System.out.println(GetDisclog(disclog));

        System.out.println(GetDisclog(disclog));

        return GetDisclog(disclog);*/
    }

    private String GetDisclog(DiscLog[] discLogs) {
        String Output = "";
        for (int i = 0; i < discLogs.length; i++) {
            Output = Output + discLogs[i].toString() + System.lineSeparator();
            ;
        }
        return Output;
    }


    class DiscLog implements Comparable<DiscLog> {
        long Xposition = 0;
        int StartandEndPosition = 0;

        public long getXposition() {
            return Xposition;
        }

        public int getStartandEndPosition() {
            return StartandEndPosition;
        }

        public DiscLog(long xposition, int startandEndPosition) {
            StartandEndPosition = startandEndPosition;
            Xposition = xposition;
        }

        @Override
        public String toString() {
            return "DiscLog{" +
                    "Xposition=" + Xposition +
                    ", StartandEndPosition=" + StartandEndPosition +
                    '}';
        }


        @Override
        public int compareTo(DiscLog o) {
            if (this.getXposition() != o.getXposition()) {
                return Long.compare(this.getXposition(), o.getXposition());
            } else {
                return Integer.compare(o.getStartandEndPosition(), this.StartandEndPosition);
            }

            //return this.Xposition!= o.Xposition ? Long.compare(this.Xposition, o.getXposition()):Integer.compare(o.StartandEndPosition,this.StartandEndPosition);
        }
    }


}

class PassingCars {
    public int CalculatePassingCars(int[] cardirection) {
        int count = 0;
        int[] suffixsum = new int[cardirection.length];
        suffixsum[cardirection.length - 1] = cardirection[cardirection.length - 1];
        System.out.println("car Direction " + Arrays.toString(cardirection));
        for (int i = cardirection.length - 2; i >= 0; i--) {
            suffixsum[i] = suffixsum[i + 1] + cardirection[i];
            if (cardirection[i] == 0) {
                count += suffixsum[i];
                if (count > 1000000000) {
                    return -1;
                }
            }
        }
        System.out.println(Arrays.toString(cardirection));
        System.out.println(Arrays.toString(suffixsum));
        return count;
    }
}

class findDivCount {

    public int calcualteDivCount(int StartNo, int EndNo, int Divcount) {
        int count = 0;
        int StartCount = StartNo / Divcount;
        int EndCount = EndNo / Divcount;
        count = EndCount - StartCount;
        if (StartNo % Divcount == 0) count += 1;
        // if (EndNo % Divcount == 0) count += 1;
        return count;

    }

}

class Flags {
    public int countFlags(int[] A) {
        int[] peaks = new int[A.length];
        int NextPeak = A.length;
        peaks[A.length - 1] = NextPeak;
        for (int i = A.length - 2; i > 0; i--) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                NextPeak = i;
            }
            peaks[i] = NextPeak;
        }
        peaks[0] = NextPeak;
        int current_guess = 0;
        int Next_guess = 0;
        while (canplaceFlag(peaks, Next_guess)) {
            current_guess = Next_guess;
            Next_guess += 1;
        }
        return current_guess;
    }

    private boolean canplaceFlag(int[] peaks, int flagstoplace) {
        int flagsplaced = 0;
        int Peakposition = 0;
        for (int i = 0; i < flagstoplace; i++) {
            if (Peakposition < peaks.length) {
                flagsplaced += 1;
            } else {
                return false;
            }
            Peakposition = peaks[Peakposition] + flagstoplace;

        }
        return true;

    }
}

class findgreatestcommonDivisor {
    public int finddivision(int A, int B) {
        int Divide = 0;
        int Divideby = A;
        int Remainder = B;

        while (Remainder != 0) {
            Divide = Divideby;
            Divideby = Remainder;
            Remainder = Divide % Divideby;
        }
        return Divideby;
    }
}

class eatchocalatebynumber {
    public int findNumberofChocalateseaten(int NoOfChocalates, int jumpPosition) {
        System.out.println(NoOfChocalates + "  No Of chocalates  to be eaten by jumping " + jumpPosition + " : ");
        return NoOfChocalates / GreatesCommomDivisior(NoOfChocalates, jumpPosition);
    }

    private int GreatesCommomDivisior(int Divideby, int ToBeDivided) {
        int by = Divideby;
        int to = ToBeDivided;
        int remainder = ToBeDivided;

        while (remainder != 0) {
            remainder = to % by;
            to = by;
            by = remainder;
        }
        return to;
    }

//    private boolean findPostioninArray(int ArraySize, int CurrentPostion, int JumpPostion) {
//
//    }

}

class finddistinctSlices {
    public int CalcualteDistinctSclices(int maxnumber, int[] A) {
        int totalslices = 0;
        int tail = 0;
        boolean[] inCurrentSlices = new boolean[maxnumber + 1];
        Arrays.fill(inCurrentSlices, false);

        for (int head = 0; head < A.length; head++) {
            if (inCurrentSlices[A[head]]) {
                //FindDuplicated
                for (int t = tail; t <= head; t++) {
                    if (A[t] == A[head]) {
                        tail = t + 1;
                        t = head + 1;
                    } else {
                        inCurrentSlices[A[t]] = false;
                    }
                }
            }
            inCurrentSlices[A[head]] = true;
            totalslices += ((head) - tail) + 1;
            if (totalslices > 1000000000) {
                totalslices = 1000000000;
            }
        }
        System.out.println("Total Slices for " + Arrays.toString(A));
        return totalslices;
    }

}


class findlowestpossiblesum {
    public int findlowestabsolutevalue(long A[]) {
        long lowestvalue = 0;
        long tempvalue = 0;
        int leftpoiter = 0;
        int rightpointer = A.length - 1;
        System.out.println(Arrays.toString(A));
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        tempvalue = A[leftpoiter] + A[rightpointer];
        lowestvalue = Math.abs(tempvalue);

        while (leftpoiter != rightpointer) {
            if (tempvalue > 0) {
                rightpointer -= 1;
            } else {
                leftpoiter += 1;
            }
            tempvalue = A[leftpoiter] + A[rightpointer];
            if (Math.abs(tempvalue) < lowestvalue) {
                lowestvalue = Math.abs(tempvalue);
            }
        }
        return (int) lowestvalue;
    }
}


class GetMaximunZeroLength {

    public int calculateMaximumZeroLength_Option2(int N) {
        int MaxLength = 0;
        String BinaryString = Integer.toBinaryString(N);
        System.out.println(BinaryString);
        Boolean StartEndZeros = true;
        while (StartEndZeros) {
            int length = BinaryString.length();
            if (BinaryString.charAt(length - 1) == '0') {
                BinaryString = BinaryString.substring(0, length - 1);
            } else {
                StartEndZeros = false;
            }
        }
        StartEndZeros = true;
        while (StartEndZeros) {
            int length = BinaryString.length();
            if (BinaryString.charAt(0) == '0') {
                BinaryString = BinaryString.substring(1, length - 1);
            } else {
                StartEndZeros = false;
            }
        }
        String[] BinaryArray = BinaryString.split("1");
        for (int i = 0; i < BinaryArray.length; i++) {
            if (MaxLength < BinaryArray[i].length()) {
                MaxLength = BinaryArray[i].length();
            }
        }


        System.out.println(BinaryString);
        return MaxLength;
    }

    public int calculateMaximumZeroLength_Option3(int N) {
        int MaxLength = 0;
        String BinaryString = Integer.toBinaryString(N);
        BinaryString = BinaryString.replaceAll("10", "S0");
        // BinaryString = BinaryString.replaceAll("01", "01A");
        String[] BinaryArray = BinaryString.split("S");
        String TmpString = "";
        for (int i = 0; i < BinaryArray.length; i++) {
            int length = 0;
            TmpString = BinaryArray[i].trim();
            length = TmpString.length();
            if (length > 0) {
                //if (TmpString.charAt(0) == '1' && TmpString.charAt(length - 1) == '1') {
                if (TmpString.charAt(length - 1) == '1') {
                    TmpString = TmpString.replaceAll("1", "");
                    if (TmpString.length() > MaxLength) MaxLength = TmpString.length();
                }
            }
        }
        return MaxLength;
    }

    public int calculateMaximumZeroLength(int N) {
        int MaxLength = 0;
        String BinaryString = Integer.toBinaryString(N);
        // String OneQuantity = BinaryString.replaceAll("10","A10");
        BinaryString = BinaryString.replaceAll("10", "A10");
        BinaryString = BinaryString.replaceAll("01", "01A");

        String[] BinaryArray = BinaryString.split("A");
        System.out.println(N + " " + BinaryString);
        System.out.println(Arrays.toString(BinaryArray));

        //  if(OneQuantity.length()>1) {
        for (int i = 0; i < BinaryArray.length; i++) {
            if (BinaryArray[i].length() > 0) {
                Character StartLetter = BinaryArray[i].trim().charAt(0);

                System.out.println("StartLetter " + StartLetter);
                System.out.println("EndLetter " + BinaryArray[i].trim().charAt(BinaryArray[i].trim().length() - 1));

                System.out.println(BinaryArray[i].trim().substring(BinaryArray[i].trim().length() - 1, BinaryArray[i].trim().length()));

                if (BinaryArray[i].trim().substring(1, 1) == "1" && BinaryArray[i].trim().substring(BinaryArray[i].trim().length() - 1, BinaryArray[i].trim().length()) == "1") {
                    if (MaxLength < BinaryArray[i].length()) {
                        MaxLength = BinaryArray[i].length();
                    }
                }

            }
        }
        return MaxLength - 2;
//         }else{
//             return 0;
//         }
    }

    ;

}


class CyclicRotationofArrays {
    public int[] RotateArray(int[] A, int RotatebyNo) {
        int[] NewRotationArray = new int[A.length];

        int NextPostion = 0;
        System.out.println(Arrays.toString(A));

        for (int i = 0; i < A.length; i++) {

            NextPostion = nextfindno(A.length, i, RotatebyNo);
            NewRotationArray[NextPostion] = A[i];
        }
        return NewRotationArray;
    }

    private int nextfindno(int ArraySize, int CurrentPosition, int Rotateby) {
        return (CurrentPosition + Rotateby) % ArraySize;
    }

}

class OddOccurencesinArray {
    public int OddOccerencenumber(int[] A) {
        System.out.println(Arrays.toString(A));
        Arrays.sort(A);
        int OddNumber = 0;
        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length; i++) {
            if (i + 1 > A.length - 1) {
                OddNumber = A[i];
            } else if (A[i] == A[i + 1]) {
                i += 1;
            } else {
                OddNumber = A[i];
            }
        }
        return OddNumber;
    }

}

class Frogjump {
    public int calculatenoofJumps(int X, int Y, int D) {

        int numberofjumps = ((Y - X) / D);
        if ((Y - X) % D > 0) {
            numberofjumps += 1;
        }
        return numberofjumps;

    }
}


class findmissingelement {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int NextNUmber = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (NextNUmber != A[i]) {
                    if (A[i] > NextNUmber) return NextNUmber;
                } else {
                    NextNUmber += 1;
                }
            }
        }
        return NextNUmber;
    }
}


class findEquilibrium {
    public int Solution(int[] A) {
      /*  int minDifference = 0;
        int LeftTraverse = 0;
        int RightTraverse = A.length - 1;
        int LeftSum = A[LeftTraverse];
        int RightSum = A[RightTraverse];
        while ((RightTraverse - LeftTraverse) > 1) {

            if ((RightSum - LeftSum) < 0) {
                RightTraverse = RightTraverse - 1;
                RightSum += A[RightTraverse];
            } else {
                LeftTraverse = LeftTraverse + 1;
                LeftSum += A[LeftTraverse];
            }
        }
        return Math.abs(LeftSum - RightSum);*/

        int TotalSum = 0;
        int LeftSum = 0;
        int RightSum = 0;
        LeftSum = A[0];
        for (int i = 1; i < A.length; i++) RightSum += A[i];
        int MinDiff = Math.abs(LeftSum - RightSum);
        for (int i = 1; i < A.length; i++) {
            LeftSum += A[i];
            RightSum -= A[i];
            if (LeftSum == 0 && RightSum == 0) {
            } else {
                int tmpDiff = Math.abs(LeftSum - RightSum);
                if (tmpDiff < MinDiff) {
                    MinDiff = tmpDiff;
                }
            }
        }
        return Math.abs(MinDiff);
    }

}

class FindEarliestTimeforFrogTopassRiver {
    public int Solution(int Distance, int[] A) {
        int Distancecovered = 0;
        boolean[] DistanceTRacker = new boolean[Distance + 1];
        int TotalDistanceRequired = (Distance * Distance + Distance) / 2;
        for (int i = 0; i < A.length; i++) {
            if (DistanceTRacker[A[i]]) {

            } else {
                DistanceTRacker[A[i]] = true;
                Distancecovered += A[i];
                if (DistanceTRacker[Distance]) {
                    if (Distancecovered == TotalDistanceRequired) return i + 1;
                }
            }

        }
        return -1;
    }
}

class MaxCounter_self {
    public int[] Solution(int N, int[] A) {
        int[] finalArray = new int[N];
        int Max = 0;
        Arrays.fill(finalArray, 0);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                Arrays.fill(finalArray, Max);
            } else {
                finalArray[A[i] - 1] += 1;
                if (finalArray[A[i] - 1] > Max) {
                    Max = finalArray[A[i] - 1];
                }
            }
        }
        return finalArray;
    }
}

class PassingCarsSelf {
    public int Solution(int[] A) {
        int[] PassingCards = new int[A.length];
        PassingCards[A.length - 1] = A[A.length - 1];
        int totalCarsPassed = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            PassingCards[i] = A[i] + PassingCards[i + 1];
            if (A[i] == 0) {
                totalCarsPassed += PassingCards[i];
                if (totalCarsPassed > 1000000000) return -1;
            }
        }
        return totalCarsPassed;
    }
}


class CountDiv{
    public int solution (int A, int B, int K){
        int totalDiv = Math.abs(B / K) - Math.abs(A / K)  ;
        if (A%K ==0){
            totalDiv += 1;
        }
        return totalDiv;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new findmissingelement().solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(Arrays.toString(new MaxCounter_self().Solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));

        System.out.println(new FindEarliestTimeforFrogTopassRiver().Solution(5, new int[]{1, 3, 1, 4, 3, 5, 3, 2, 4}));
        System.out.println(new findEquilibrium().Solution((new int[]{3, 1, 2, 4, 3})));
        System.out.println(new findEquilibrium().Solution((new int[]{-1000, 1000})));

        System.out.println(new findEquilibrium().Solution((new int[]{-2, -3, -4, -1})));


        System.out.println(new Frogjump().calculatenoofJumps(10, 85, 30));
        System.out.println(new Frogjump().calculatenoofJumps(3, 999111321, 7));

        System.out.println(new OddOccurencesinArray().OddOccerencenumber(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(new OddOccurencesinArray().OddOccerencenumber(new int[]{9, 3, 9, 3, 9, 7, 9, 7, 11}));
        System.out.println(Arrays.toString(new CyclicRotationofArrays().RotateArray(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(new Arrayexamples().ArrayCyclicrotation(new int[]{3, 8, 9, 7, 6}, 3));
        System.out.println(new GetMaximunZeroLength().calculateMaximumZeroLength_Option2(1041));
        System.out.println(new GetMaximunZeroLength().calculateMaximumZeroLength_Option2(5));
        System.out.println(new GetMaximunZeroLength().calculateMaximumZeroLength_Option2(2147483647));
        System.out.println(new GetMaximunZeroLength().calculateMaximumZeroLength_Option2(32));

        System.out.println(new findlowestpossiblesum().findlowestabsolutevalue(new long[]{-7, 3, -1, 5, -11, 4, -9, 14, 17, -2}));
        System.out.println(new findlowestpossiblesum().findlowestabsolutevalue(new long[]{8, 3, 5, 16, 11}));
        System.out.println(new findlowestpossiblesum().findlowestabsolutevalue(new long[]{-7, -5, -6, -2, -9}));
        System.out.println(new findlowestpossiblesum().findlowestabsolutevalue(new long[]{-7, 3, -6, 1, 0, -9}));
        System.out.println(new findlowestpossiblesum().findlowestabsolutevalue(new long[]{-22, 3, 4, 5}));

        System.out.println(new finddistinctSlices().CalcualteDistinctSclices(9, new int[]{2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1}));
        System.out.println(new finddistinctSlices().CalcualteDistinctSclices(6, new int[]{3, 4, 5, 5, 2}));

        System.out.println(new eatchocalatebynumber().findNumberofChocalateseaten(39, 27));
        System.out.println(new eatchocalatebynumber().findNumberofChocalateseaten(10, 4));
        System.out.println(new eatchocalatebynumber().findNumberofChocalateseaten(9, 6));
        System.out.println(new eatchocalatebynumber().findNumberofChocalateseaten(10, 11));

        System.out.println(new findgreatestcommonDivisor().finddivision(39, 27));
        System.out.println(new findgreatestcommonDivisor().finddivision(742, 518));

        System.out.println("Max Flags that can be placed" + new Flags().countFlags(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));

        System.out.println(new findDivCount().calcualteDivCount(4, 17, 3));
        System.out.println(new findDivCount().calcualteDivCount(3, 17, 3));
        System.out.println(new findDivCount().calcualteDivCount(3, 18, 3));
        System.out.println(new findDivCount().calcualteDivCount(4, 18, 3));
        System.out.println(new findDivCount().calcualteDivCount(6, 11, 2));
        System.out.println(new PassingCars().CalculatePassingCars(new int[]{0, 1, 0, 1, 1}));
        System.out.println(new NumberofDiscIntersections().DiscLog(new int[]{1, 5, 2, 1, 4, 0}));
        System.out.println(new MaxProfit().getMaximumsum(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));

        System.out.println(new StacksAndQueues().Dominator(new int[]{3, 0, 1, 1, 4, 1, 1}));
        System.out.println(new StacksAndQueues().Dominator(new int[]{1, 2, 3, 4, 5, 6, 7}));


        System.out.println(new StacksAndQueues().Fishsurvivors(new int[]{1, 0, 0, 1, 1}, new int[]{4, 8, 2, 6, 7}));
        System.out.println(new StacksAndQueues().Fishsurvivors(new int[]{1, 0, 1, 1, 1}, new int[]{4, 3, 2, 1, 5}));

        System.out.println(new StacksAndQueues().BracketsUsingStacks("({}[])()[{}]"));
        System.out.println(new StacksAndQueues().BracketsUsingStacks("(){}[]()[]{}"));
        System.out.println(new StacksAndQueues().BracketsUsingStacks("({[}[])()[{}]"));
        System.out.println("find maxcounter {1, 2, 3, 4, 5,3,3,1,2,4,7, 1,5,4,5,5}: " + new maxcounter().Maxcounter((new int[]{1, 2, 3, 4, 5, 3, 3, 1, 2, 4, 7, 1, 5, 4, 5, 5}), 5));

        System.out.println("Using FindEquilibrium {1, 2, 3, 4, 5}: " + new Arrayexamples().ArrayCyclicrotation((new int[]{1, 2, 3, 4, 5}), 1));
        System.out.println("Using FindEquilibrium {1, 2, 3, 4, 5}: " + new Arrayexamples().ArrayCyclicrotation((new int[]{1, 2, 3, 4, 5}), 3));
      /* System.out.println("Using FindEquilibrium {3,1,2,4,3}: " +  new GetEquilibrium().FindEquilibrium(new int[]{3,1,2,4,3}));
        System.out.println("Using Option 2 {3,1,2,4,3}: " + new GetEquilibrium().Option2(new int[]{3,1,2,4,3}));
        System.out.println("Using FindEquilibrium {3,1,2,4,3,9}: " + new GetEquilibrium().FindEquilibrium(new int[]{3,1,2,4,3,9}));
        System.out.println("Using Option 2 {3,1,2,4,3,9}: " + new GetEquilibrium().Option2(new int[]{3,1,2,4,3,9}));
        System.out.println("Using FindEquilibrium {20,1,2,4,3,9}: " + new GetEquilibrium().FindEquilibrium(new int[]{20,1,2,4,3,9}));
        System.out.println("Using Option 2 {20,1,2,4,3,9}: " + new GetEquilibrium().Option2(new int[]{20,1,2,4,3,9}));
        System.out.println("Using FindEquilibrium {20,1,2,4,3,99}: " + new GetEquilibrium().FindEquilibrium(new int[]{20,1,2,4,3,99}));
        System.out.println("Using Option 2 {20,1,2,4,3,99}: " + new GetEquilibrium().Option2(new int[]{20,1,2,4,3,99}));
*/


       /* System.out.println(new GetMissingNumber().findmissingnumber(new int[]{1, 4, 2, 3, 6, 8, 7}));
        System.out.println(new GetMissingNumber().findmissingnumber(new int[]{1,5 , 2, 3 }));
        System.out.println(new GetMissingNumber().findmissingnumber(new int[]{}));

        */
    }
}

