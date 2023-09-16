model lab04_03
parameter Real x0 = 2;
parameter Real y0 = 0;
parameter Real w = 1;
parameter Real g = 4;
Real x(start = x0);
Real y(start = y0);
Real t = time;
equation
  der(x) = y;
  der(y) = -w * der(x) - g*x - cos(2*t);
end lab04_03;
