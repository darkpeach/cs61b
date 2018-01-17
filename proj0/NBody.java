public class NBody {
	public static double readRadius(String s){
		In in = new In(s);
		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String s){
		In in = new In(s);
		int numberOfPlanet = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numberOfPlanet];
		for(int i = 0; i < numberOfPlanet; i++){
			planets[i] =  new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		return planets;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		for(Planet p: planets){
			p.draw();
		}
		double time = 0;
		while(time <= T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int j = 0; j < planets.length; j++){
				planets[j].update(dt, xForces[j], yForces[j]);
			}
			StdDraw.picture(0,0, "./images/starfield.jpg");
			for(Planet p: planets){
				p.draw();
			}
			StdDraw.show(10);
			time += dt;
		}
	}
}
