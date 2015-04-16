package tasks;

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
//				dist[i][j] = dist[j][i] = dist(cities[i],cities[j]);
//			}
//		}
	}
	
	@Override
	public List<Integer> execute() {
		return null;
	}

}
