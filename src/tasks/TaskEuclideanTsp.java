package tasks;

import java.util.List;

import api.Task;

public class TaskEuclideanTsp implements Task<List<Integer>> {
	private double[][] cities;

	public TaskEuclideanTsp(double[][] cities) {	
		this.cities = cities;
	}
	
	@Override
	public List<Integer> execute() {
		return null;
	}

}
