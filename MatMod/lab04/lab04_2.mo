model lab04_2
parameter Real x0 = 2;
parameter Real y0 = 0;
parameter Real w = 3;
parameter Real g = 9;
Real x(start = x0);
Real y(start = y0);
equation
  der(x) = y;
  der(y) = -w * der(x) - g*x;
end lab04_2;
