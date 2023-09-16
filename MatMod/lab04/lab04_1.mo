model lab04_1
parameter Real x0 = 2;
parameter Real y0 = 0;
parameter Real w = 7;
Real x(start = x0);
Real y(start = y0);
equation
  der(x) = y;
  der(y) = -w * x;
end lab04_1;
