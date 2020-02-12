package abstract_class_test;

public class Circle extends Shape {
	
	private double radius;

	public Circle(String color,double radius) {
		super(color);
		this.radius=radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radius;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return getColor()+"£¬ Ô²ÐÎ";
	}

}
