package tasks;

import java.util.PermutationEnumerator;
import java.util.ArrayList;
import java.util.List;

import api.Task;

public class TaskEuclideanTsp implements Task<List<Integer>> {
	private double[][] cities;
	private double[][] dist;

	public TaskEuclideanTsp(double[][] cities) {	
		this.cities = cities;
		this.dist = new double[cities.length][cities.length];
//		for(int i=0;i<this.cities.length;i++){
//			for(int j=0;j<this.cities.length;j++) {
//				dist[i][j] = dist(cities[i],cities[j]);
//				dist[j][i] = dist(cities[j],cities[i]);
//				
//			}
//		}
	}
	
	@Override
	public List<Integer> execute() {
		List<Integer> partialTour = initialTour();
		List<Integer> shortestTour = new ArrayList<>( partialTour );
		shortestTour.add(0,0);
		double shortestTourDistance = tourDist(shortestTour);
		
		PermutationEnumerator<Integer> permutationEnumerator = new PermutationEnumerator<>(partialTour);
		for( List<Integer> subtour = permutationEnumerator.next(); subtour != null; subtour = permutationEnumerator.next()) {
			List<Integer> tour = new ArrayList<>(subtour);
			tour.add(0,0);
			if(tour.indexOf(1) > tour.indexOf(2)) {
				continue;
			}
			double tourDist = tourDist(tour);
			if( tourDist < shortestTourDistance) {
				shortestTour = tour;
				shortestTourDistance = tourDist;
			}
		}
		return shortestTour;
	}

	private double tourDist(List<Integer> shortestTour) {
		double cost = dist[shortestTour.get(shortestTour.size()-1)][shortestTour.get(0)];
		for(city=0;city<shortestTour.size()-1;city++) {
			cost += dist[ shortestTour.get( city ) ][ shortestTour.get( city + 1 ) ];
		}
		return cost;
	}

	private List<Integer> initialTour() {
		List<Integer> tour = new ArrayList<>();
		for(int city=1; city<cities.length;city++) {
			tour.add(city);
		}
		return tour;
	}

}
