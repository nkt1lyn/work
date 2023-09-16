model lab_05
parameter Real a = 0.22;
parameter Real b = 0.051;
parameter Real c = 0.33;
parameter Real d = 0.041;

parameter Real x0 = 3;
parameter Real y0 = 8;

Real x(start = x0);
Real y(start = y0);

equation

der(x) = -a*x + b*x*y;
der(y) = c*y - d*x*y;

end lab_05;
