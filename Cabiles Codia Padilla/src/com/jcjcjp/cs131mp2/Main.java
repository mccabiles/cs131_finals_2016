package com.jcjcjp.cs131mp2;

/*
 * ==================================
 * MAIN FUNCTION
 * This serves as a template or guide for the use of the library.
 * ---------------------------------
 * USAGE: 
 * 1. Define your ODE by extending the ODEFunction class.
 * 2. Override the f( t, y ) method with the function you will use.
 * 3. Instantiate your ODE object.
 * 4. Call the methods with the initial values and the ODE object as arguments.
 * ---------------------------------
 * METHOD CALLS:
 * 		> Euler.odeSystem( t, y, h, n, function )
 * 		> Heun.odeSystem( t, y, h, n, function )
 * 		> RK4.odeSystem( t, y, h, n, function )
 * 
 * 		ARGUMENTS:
 * 			t = initial value of t
 * 			y = initial values of y vector
 * 			h = step size
 * 			n = number of iterations
 * 			function = ODE object
 * ==================================
 */
	
class myODEFunction extends ODEFunction
{
	// Define your function here:
	@Override
	public double[] f(double t, double[] y) 
	{
		double[] new_y = new double[2];
		double g = 32.2;
		double l = 2;
		
		new_y[0] = y[1];
		new_y[1] = (-g/l) * Math.sin( y[0] );
		return new_y;
	}
}


public class Main
{
	
	public static void run( double t0, double[] y0, int n, double h ) {

		// Set the initial conditions:
			/*double[] y0 = new double[2]; // Our initial condition is y = [ pi/4, 0 ]
			y0[0] = Math.PI /4;
			y0[1] = 0;
			
			double h = 0.05;
			int n = 33;
			*/
			
		// Instantiate your ODE:
			myODEFunction function = new myODEFunction();
		
		// Call the methods:
			double[][] euler_values, heun_values, rk4_values;
			
			
			euler_values = Euler.odeSystem(t0, y0, h, n, function);
			heun_values = Heun.odeSystem(t0, y0, h, n, function);
			rk4_values = RK4.odeSystem(t0, y0, h, n, function);
			
		// Print the results:
			System.out.printf("Euler (h = %.2f):\n", h);
			ODEFunction.print( euler_values, 1 );
			
			System.out.printf("\n Heun (h = %.2f):\n", h);
			ODEFunction.print( heun_values, 1 );
			
			System.out.printf("\n RK4 (h = %.2f):\n", 1);
			ODEFunction.print( rk4_values, 1 );
			
			
	}
	
	public static void main(String[] args) {
		
		// initialize the GUI:
		new GUI(0);    
	}
	
	

}
