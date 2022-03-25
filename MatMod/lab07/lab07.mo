model lab07
parameter Real N = 995;
parameter Real n0 = 9;

parameter Real a1 = 0.95; //первый случай
parameter Real a2 = 0.0008;

//parameter Real a1 = 0.000095; //второй случай
//parameter Real a2 = 0.92;

//parameter Real a1 = 0.95; //третий случай
//parameter Real a2 = 0.93;

Real n(start = n0);
equation
der(n) = (a1+a2*n)*(N - n);
end lab07;
