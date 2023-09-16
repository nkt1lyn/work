model lab06_01
parameter Real a = 0.01;
parameter Real b = 0.02;
parameter Real N = 16000;
parameter Real I0 = 116;
parameter Real R0 = 16;
parameter Real S0 = N - I0 - R0;

Real I(start = I0);
Real R(start = R0);
Real S(start = S0); 
equation
der(S) = 0;
der(I) = - b*I;
der(R) = b*I;
end lab06_01;
