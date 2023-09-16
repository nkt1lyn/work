model lab03_2
  parameter Real a = 0.44;
  parameter Real b = 0.7;
  parameter Real c = 0.33;
  parameter Real h = 0.61;
  parameter Real x0 = 21200;
  parameter Real y0 = 9800;
  
  Real t = time;
  Real x(start = x0);
  Real y(start = y0);
equation
   der(x) = -a*x-b*y+sin(2*t);
   der(y) = -c*x-h*y+cos(t+2);
end lab03_2;
