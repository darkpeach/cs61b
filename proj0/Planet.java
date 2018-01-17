public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		return Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
	}
	public double calcForceExertedBy(Planet p){
		return this.mass * p.mass * 6.67e-11 / Math.pow(this.calcDistance(p), 2);
	}
	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p) / this.calcDistance(p) * (p.yyPos - this.yyPos);
	}
	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p) / this.calcDistance(p) * (p.xxPos - this.xxPos);
	}
	public double calcNetForceExertedByX(Planet[] planets){
		double forceX = 0;
		for(Planet p: planets){
			if(!this.equals(p)){
				forceX += this.calcForceExertedByX(p);
			}
		}
		return forceX;
	}
	public double calcNetForceExertedByY(Planet[] planets){
		double forceY = 0;
		for(Planet p: planets){
			if(!this.equals(p)){
				forceY += this.calcForceExertedByY(p);
			}
		}
		return forceY;
	}
	public void update(double time, double forceX, double forceY){
		double accX = forceX / this.mass;
		double accY = forceY / this.mass;
		this.xxVel += accX * time;
		this.yyVel += accY * time;
		this.xxPos += this.xxVel * time;
		this.yyPos += this.yyVel * time;
	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}
