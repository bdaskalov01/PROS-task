package com.PROSInternshipTask.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskApplicationTest {

    @Test
    void checkIfDestinationCanBeReached() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[3][2];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[2][0] = "CMB";
        flights[2][1] = "LON";

        String origin = "SOF";
        String destination = "LON";

        assertEquals(3, taskApplication.soloTravel(flights, origin, destination));

    }

    @Test
    void checkIfDestinationCantBeReached() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[4][2];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[2][0] = "CMB";
        flights[2][1] = "LON";
        flights[3][0] = "MLE";
        flights[3][1] = "ENG";

        String origin = "SOF";
        String destination = "ENG";

        assertEquals(0, taskApplication.soloTravel(flights, origin, destination));

    }

    @Test
    void checkIfTravelerCanTravelBackwards() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[4][2];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[2][0] = "CMB";
        flights[2][1] = "IST";
        flights[3][0] = "CMB";
        flights[3][1] = "LON";

        String origin = "SOF";
        String destination = "LON";

        assertEquals(3, taskApplication.soloTravel(flights, origin, destination));

    }

    @Test
    void checkForShortestSoloRoute() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[3][2];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[2][0] = "SOF";
        flights[2][1] = "CMB";

        String origin = "SOF";
        String destination = "CMB";

        assertEquals(1, taskApplication.soloTravel(flights, origin, destination));

    }


    @Test
    void checkIfGroupDestinationCanBeReached() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[3][3];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[0][2] = "5";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[1][2] = "5";
        flights[2][0] = "CMB";
        flights[2][1] = "LON";
        flights[2][2] = "5";

        String origin = "SOF";
        String destination = "LON";
        int groupSize = 3;

        assertEquals(3, taskApplication.groupTravel(flights, origin, destination, groupSize));

    }

    @Test
    void checkIfGroupDestinationCantBeReached() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[3][3];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[0][2] = "5";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[1][2] = "5";
        flights[2][0] = "CMB";
        flights[2][1] = "LON";
        flights[2][2] = "5";

        String origin = "SOF";
        String destination = "LON";
        int groupSize = 6;

        assertEquals(0, taskApplication.groupTravel(flights, origin, destination, groupSize));

    }

    @Test
    void checkForShortestGroupRoute() {
        TaskApplication taskApplication = new TaskApplication();
        String[][] flights = new String[3][3];
        flights[0][0] = "SOF";
        flights[0][1] = "IST";
        flights[0][2] = "5";
        flights[1][0] = "IST";
        flights[1][1] = "CMB";
        flights[1][2] = "5";
        flights[2][0] = "CMB";
        flights[2][1] = "LON";
        flights[2][2] = "5";
        flights[2][0] = "SOF";
        flights[2][1] = "LON";
        flights[2][2] = "5";

        String origin = "SOF";
        String destination = "LON";
        int groupSize = 3;

        assertEquals(1, taskApplication.groupTravel(flights, origin, destination, groupSize));

    }
}