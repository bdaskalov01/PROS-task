package com.PROSInternshipTask.Task;


import java.sql.SQLOutput;

public class TaskApplication {

	public static void main(String[] args) {

	}

	public int soloTravel(String[][] flights, String origin, String destination) {
		// Declaring the variables that will be used throughout the function.
		int hoursSpentFlying = 0;
		int[] hoursSpentForEachRoute = new int[flights.length];
		int hoursSpentForEachRouteCounter = 0;
		int visitedCountriesCounter = 0;
		String[] passedCountries = new String[flights.length];
		String currentCountry = origin;

		// Creating a parent for loop that loops through the whole flights array.
		for (int i = 0; i < flights.length; i++) {
			// Creating a nested loop to check for other possible routes.
				for (int j = i; j  < flights.length; j++) {
					// Checks if the currently selected flights departs from the country we are currently located in.
					// It also checks if we have been already in the country that the flight will travel to
					// and prevents from traveling backwards.
						if ((flights[j][0].equals(currentCountry)) && !checkIfCountryHasAlreadyBeenVisited(passedCountries, flights[j][1])) {
							// If the flight lands in the destination country, it adds the total amount of hours this route took
							// and we store it in the hoursSpentForEachRoute array followed by breaking out of the nested loop
							// and getting to the next iteration of the first loop.
							if (flights[j][1].equals(destination)) {
								hoursSpentFlying++;
								hoursSpentForEachRoute[hoursSpentForEachRouteCounter] = hoursSpentFlying;
								hoursSpentForEachRouteCounter++;
								break;
							}
							// If the flight doesn't land in the destination country, it increases the total amount of hours
							// this route took, adds the country we arrived from to the passedCountries array, and changes
							// the value of currentCountry to the country we just arrived in.
							else {
								hoursSpentFlying++;
								passedCountries[visitedCountriesCounter] = currentCountry;
								currentCountry = flights[j][1];
								visitedCountriesCounter++;
							}
						}
						else {
							System.out.println("Country has been passed before. Can't travel backwards.");
						}
				}
				//At the end of each iteration of the parent for loop, change the key variables back to the
			    //state they were before the nested loop.
				hoursSpentFlying = 0;
				currentCountry = origin;
				passedCountries = new String[flights.length];
		}

		// Declare the variable that stores the lowest integer from the hoursSpentForEachRoute array.
		final int shortestRouteLimit = 100;
		int shortestRoute = shortestRouteLimit;

		// For loop that iterates through the hoursSpentForEachRoute array and the currently selected
		// element gets set as the new value of the shortestRoute variable if it's lower than said variable.
		for (int i = 0; i < hoursSpentForEachRoute.length; i++) {
			if ((hoursSpentForEachRoute[i] < shortestRoute) && (hoursSpentForEachRoute[i] > 0)){
				shortestRoute = hoursSpentForEachRoute[i];
			}
		}

		// If the shortestRoute variable is higher than 0 and its value has been changed since it was declared
		// its value gets returned from the function.
		if ((shortestRoute > 0) && (shortestRoute != shortestRouteLimit)) {
			return shortestRoute;
		}

		// If nothing else was returned up to this point, the function returns 0.
		return 0;
	}

	public int groupTravel(String[][] flights, String origin, String destination, int groupSize) {
		int hoursSpentFlying = 0;
		int[] hoursSpentForEachRoute = new int[flights.length];
		int hoursSpentForEachRouteCounter = 0;
		int visitedCountriesCounter = 0;
		String[] passedCountries = new String[flights.length];
		String currentCountry = origin;

		for (int i = 0; i < flights.length; i++) {
				for (int j = i; j  < flights.length; j++) {


						// Checks if the third column of the j-th row is equal or greater than the passed variable groupSize.
						if ((flights[j][0].equals(currentCountry)) && !checkIfCountryHasAlreadyBeenVisited(passedCountries, flights[j][0])
								&& (Integer.valueOf(flights[j][2]) >= groupSize)) {
							if (flights[j][1].equals(destination)) {
								hoursSpentFlying++;
								hoursSpentForEachRoute[hoursSpentForEachRouteCounter] = hoursSpentFlying;
								hoursSpentForEachRouteCounter++;
								break;
							}
							else {
								hoursSpentFlying++;
								passedCountries[visitedCountriesCounter] = currentCountry;
								currentCountry = flights[j][1];
								visitedCountriesCounter++;
							}
						}
						else if ((flights[j][0].equals(currentCountry)) && !checkIfCountryHasAlreadyBeenVisited(passedCountries, flights[j][0])
								&& !(Integer.valueOf(flights[j][2]) >= groupSize)) {
							System.out.println("Not enough seats for the whole group.");
						}
						else {
							System.out.println("Country has been passed before. Can't travel backwards.");
						}
				}
				hoursSpentFlying = 0;
				currentCountry = origin;
				passedCountries = new String[flights.length];
		}

		final int shortestRouteLimit = 100;
		int shortestRoute = shortestRouteLimit;

		for (int i = 0; i < hoursSpentForEachRoute.length; i++) {
			if ((hoursSpentForEachRoute[i] < shortestRoute) && (hoursSpentForEachRoute[i] > 0)){
				shortestRoute = hoursSpentForEachRoute[i];
			}
		}

		if ((shortestRoute > 0) && (shortestRoute != shortestRouteLimit)) {
			return shortestRoute;
		}
		return 0;
	}

	// Function type boolean that loops through the visitedCountries array and checks if any of its elements equals the
	// passed variable specificCountry.
	private static boolean checkIfCountryHasAlreadyBeenVisited(String[] visitedCountries, String specificCountry) {
		for (int i = 0; i < visitedCountries.length; i++) {
			if (visitedCountries[i] != null) {
				// If the array contains an element that equals specificCountry
				// it returns true.
				if (visitedCountries[i].equals(specificCountry)) {
					return true;
				}
			}
		}

		// If the for loop has ended and hasn't returned anything, return false by default.
		return false;
	}

}
