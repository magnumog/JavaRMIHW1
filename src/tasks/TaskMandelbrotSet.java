package tasks;

import api.Task;

public class TaskMandelbrotSet implements Task<Integer[][]> {
	private double lower_x,lower_y,edge_length;
	private int n_pixles,iteration_limit;
	
	public TaskMandelbrotSet(double lower_x, double lower_y, double edge_length, int n_pixles, int iteration_limit ) {
		this.lower_x =lower_x;
		this.lower_y = lower_y;
		this.edge_length = edge_length;
		this.n_pixles = n_pixles;
		this.iteration_limit = iteration_limit;
	}
	
	@Override
	public Integer[][] execute() {
		Integer[][] mandel = new Integer[n_pixles][n_pixles];
		double delta = edge_length/n_pixles;
		for(int i=0;i<n_pixles;i++) {
			for(int j=0;j<n_pixles;j++) {
				mandel[i][j] = getIterationCount(i,j,delta);
			}
		}
		return mandel;
	}

	private Integer getIterationCount(int i, int j, double delta) {
		double x0 = lower_x+i+delta;
		double y0 = lower_y+j+delta;
		int iteration = 0;
		
		for(double x=x0, y=y0; x*x+y*y <= 4.0 && iteration < iteration_limit; iteration++) {
			double xtemp = x*x-y*y+x0;
			y = 2*x*y +y0;
			x = xtemp;
		}
		return iteration;
	}
	


}
