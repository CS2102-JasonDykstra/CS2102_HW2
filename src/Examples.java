import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;

public class Examples {

    /*
    // This shows what a test case looks like
    @Test
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */


    //HOMEWORK 1 TEST CASES

    @Test
    public void testInitializeRugbyTeam() {
        RugbyTeam testTeam = new RugbyTeam("Ireland", "Green", true, 0, 0);
        assertEquals("Ireland", testTeam.country);
    }

    @Test
    public void testInitializeRoboticsTeam() {
        RoboticsTeam testTeam = new RoboticsTeam("WPI", "Breaks a lot", 0);
        assertEquals("WPI", testTeam.school);
    }

    @Test
    public void testInitializeRugbyResult() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 1.5, 1.5);
        assertEquals("Ireland", testRugbyResult.team1.country);
    }

    @Test
    public void testInitializeRoboticsResult() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 0);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals("WPI", testRoboticsResult.team1.school);
    }

    @Test
    public void testRugbyTeamExpectToBeatOneInitmidationRitual() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 0, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", false, 0, 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatBothIntimidationRitual() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatBothIntimidationRitualandTie() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 1, 0);
        assertEquals(false, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatNeitherIntimidationRitualand() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", false, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", false, 0, 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatNeitherIntimidationRitualandTie() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", false, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", false, 1, 0);
        assertEquals(false, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatOtherOneInitmidationRitual() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", false, 0, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        assertEquals(false, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRoboticsTeamExpectToBeatPreviousScoresEqual() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 0);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        assertEquals(false, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRoboticsTeamExpectToBeatPreviousScoresNotEqual() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyResultIsValidTrue() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 1.5, 1.5);
        assertEquals(true, testRugbyResult.isValid());

    }

    @Test
    public void testRugbyResultIsValidFalse1() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 200, 1.5);
        assertEquals(false, testRugbyResult.isValid());
    }

    @Test
    public void testRugbyResultIsValidFalse2() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 1.5, 200);
        assertEquals(false, testRugbyResult.isValid());
    }

    @Test
    public void testRugbyResultIsValidFalse3() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 200, 200);
        assertEquals(false, testRugbyResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidTrue1() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(true, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidTrue2() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 16, 3, false,
                10, 3, false);
        assertEquals(true, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidTrue3() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                16, 3, false);
        assertEquals(true, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidTrue4() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 16, 3, false,
                16, 3, false);
        assertEquals(true, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse1() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 20, 3, false,
                10, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse2() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                20, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse3() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 20, 3, false,
                20, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse4() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 8, false,
                10, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse5() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 8, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse6() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 8, false,
                10, 8, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse7() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 20, false,
                10, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse8() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 20, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse9() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 20, false,
                10, 20, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse10() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 8, false,
                10, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse11() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 17, 3, false,
                17, 8, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse12() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 17, 8, false,
                17, 8, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse13() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 17, 20, false,
                17, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse14() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 17, 3, false,
                17, 20, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse15() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 17, 20, false,
                17, 20, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultGetScoreNoFall() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(4.0, testRoboticsResult.getScore(1, 3, false), 0.01);
    }

    @Test
    public void testRoboticsResultGetScoreYesFall() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(-1.0, testRoboticsResult.getScore(1, 3, true), 0.01);
    }

    @Test
    public void testRugbyResultGetWinnerTeam1() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 100, 0);
        assertEquals(testTeam1, testRugbyResult.getWinner());
    }

    @Test
    public void testRugbyResultGetWinnerTeam2() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 0, 100);
        assertEquals(testTeam2, testRugbyResult.getWinner());
    }

    @Test
    public void testRoboticsResultGetWinnerTeam1() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 12, 3, false,
                10, 3, true);
        assertEquals(testTeam1, testRoboticsResult.getWinner());
    }

    @Test
    public void testRoboticsResultGetWinnerTeam2() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, true,
                10, 3, false);
        assertEquals(testTeam2, testRoboticsResult.getWinner());
    }

    @Test
    public void testMatchWinnerTeam1() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, true);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(testTeam1, testMatch.winner());
    }

    @Test
    public void testMatchWinnerTeam2() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, true,
                10, 3, false);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(testTeam2, testMatch.winner());
    }

    @Test
    public void testMatchWinnerTeam3() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, true,
                10, 3, false);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(testTeam2, testMatch.winner());
    }

    @Test
    public void testMatchNull() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10000, 3, true,
                10, 3, false);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(null, testMatch.winner());
    }




    //HOMEWORK 2 TEST CASES

    //Rugby Team
    RugbyTeam IRL = new RugbyTeam("Ireland", "Green", true, 1, 0);
    RugbyTeam FIN = new RugbyTeam("Finland", "Blue", true, 0, 0);
    RugbyTeam CAN = new RugbyTeam("Canada", "Red", true, 9, 3);
    RugbyTeam USA = new RugbyTeam("USA", "Yellow", true, 10, 2);
    RugbyTeam JPN = new RugbyTeam("Japan", "White", false, 30, 0);
    RugbyTeam THA = new RugbyTeam("Thailand", "Pink", false, 15, 2);
    RugbyTeam SWE = new RugbyTeam("Sweden", "Maroon", false, 10, 9);
    RugbyTeam NIG = new RugbyTeam("Nigeria", "Black", false, 12, 2);

    //Rugby Results
    RugbyResult FINwin = new RugbyResult(FIN, IRL, 149, 0);
    RugbyResult USAwin = new RugbyResult(USA, CAN, 149, 148);
    RugbyResult THAwin = new RugbyResult(THA, JPN, 101, 1);
    RugbyResult NIGwin = new RugbyResult(NIG, SWE, 5, 3);
    RugbyResult USAwin2 = new RugbyResult(USA, FIN, 120, 69);
    RugbyResult THAwin2 = new RugbyResult(THA, NIG, 39, 4);
    RugbyResult USAwin3 = new RugbyResult(USA, THA, 19, 18);

    //Matches
    Match FINvIRL = new Match(FIN, IRL, FINwin);
    Match USAvCAN = new Match(USA, CAN, USAwin);
    Match THAvJPN = new Match(THA, JPN, THAwin);
    Match NIGvSWE = new Match(NIG, SWE, NIGwin);
    Match USAvFIN = new Match(USA, THA, USAwin2);
    Match THAvNIG = new Match(THA, NIG, THAwin2);
    Match USAvTHA = new Match(USA, THA, USAwin3);

    //Initial Rounds
    LinkedList<Match> round1 = new LinkedList<Match>();
    LinkedList<Match> round2 = new LinkedList<Match>();
    LinkedList<Match> round3 = new LinkedList<Match>();
    LinkedList<IContestant> iWinner1 = new LinkedList<IContestant>();
    LinkedList<IContestant> iWinner2 = new LinkedList<IContestant>();
    LinkedList<IContestant> iWinner3 = new LinkedList<IContestant>();
    InitRound R1 = new InitRound(round1);
    InitRound R2 = new InitRound(round2);
    InitRound R3 = new InitRound(round3);

    //Advanced Rounds
    LinkedList<IContestant> pWinner = new LinkedList<IContestant>();
    LinkedList<Match> semiFinal = new LinkedList<>();
    AdvancedRound sem = new AdvancedRound(semiFinal, pWinner);

    //Tournament
    LinkedList<IWinner> tourney = new LinkedList<IWinner>();
    Tournament T = new Tournament(tourney);

    public Examples() {
        round1.add(FINvIRL);
        round1.add(USAvCAN);
        iWinner1.add(FIN);
        iWinner1.add(USA);

        round2.add(THAvJPN);
        round2.add(NIGvSWE);
        iWinner2.add(THA);
        iWinner2.add(NIG);

        round3.add(USAvCAN);
        iWinner3.add(USA);

        semiFinal.add(USAvFIN);
        semiFinal.add(THAvNIG);
        pWinner.add(USA);
        pWinner.add(THA);

        tourney.add(R1);
        tourney.add(R2);
        tourney.add(R3);
        tourney.add(sem);
    }

    @Test
    public void testgetMatchWinnersround1() {
        assertEquals(iWinner1, R1.getMatchWinners());
    }

    @Test
    public void testgetMatchWinnerssemFinal() {
        assertEquals(pWinner, sem.getMatchWinners());
    }

    @Test
    public void testgetNumWinnersround2() {
        assertEquals(2, R2.getNumWinners());
    }

    @Test
    public void testgetNumWinnerssemFinal() {
        assertEquals(2, sem.getNumWinners());
    }

    @Test
    public void testisWinnerround1True() {
        assertTrue(R1.isWinner(FIN));
    }

    @Test
    public void testisWinnerround1False() {
        assertFalse(R1.isWinner(IRL));
    }

    @Test
    public void testisWinnersemFinalTrue() {
        assertTrue(sem.isWinner(USA));
    }

    @Test
    public void testisWinnerrsemFinalFalse() {
        assertFalse(sem.isWinner(NIG));
    }

    @Test
    public void testfinalWinnerIsValidTrue() {
        assertTrue(T.finalWinnerIsValid(USA));
    }

    @Test
    public void testfinalWinnerIsValidFalse() {
        assertFalse(T.finalWinnerIsValid(IRL));
    }

    @Test
    public void testfinalWinnerIsValidTrueTHA() {
        assertTrue(T.finalWinnerIsValid(THA));
    }
}
