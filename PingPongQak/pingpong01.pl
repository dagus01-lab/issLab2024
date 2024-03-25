%====================================================================================
% pingpong01 description   
%====================================================================================
dispatch( msg, msg(N) ). %messaggio inviato che si aspetta o meno una sola risposta
%====================================================================================
context(ctxpingpong, "localhost",  "TCP", "8000").
 qactor( a, ctxpingpong, "it.unibo.a.A").
 static(a).
  qactor( b, ctxpingpong, "it.unibo.b.B").
 static(b).
