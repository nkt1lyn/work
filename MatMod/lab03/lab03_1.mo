model lab03_1
  parameter Real a = 0.45;
  parameter Real b = 0.86;
  parameter Real c = 0.49;
  parameter Real h = 0.73;
  parameter Real x0 = 21200;
  parameter Real y0 = 9800;
  
  Real t = time;
  Real x(start = x0);
  Real y(start = y0);
equation
   der(x) = -a*x-b*y+sin(t+1);
   der(y) = -c*x-h*y+cos(t+2);
end lab03_1;
