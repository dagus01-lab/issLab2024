%====================================================================================
% ffd description   
%====================================================================================
dispatch( oni1, oni1(N) ).
dispatch( oni2, oni2(N) ).
dispatch( offi1, offi1(N) ).
dispatch( offi2, offi2(N) ).
dispatch( set1, set1(N) ).
dispatch( set0, set0(N) ).
dispatch( reset1, reset1(N) ).
dispatch( reset0, reset0(N) ).
event( output, output(N) ).
%====================================================================================
context(ctxffd, "localhost",  "TCP", "8080").
 qactor( norset, ctxffd, "it.unibo.norset.Norset").
 static(norset).
  qactor( norreset, ctxffd, "it.unibo.norreset.Norreset").
 static(norreset).
  qactor( ffdcircuit, ctxffd, "it.unibo.ffdcircuit.Ffdcircuit").
 static(ffdcircuit).
  qactor( observer, ctxffd, "it.unibo.observer.Observer").
 static(observer).
  qactor( clientmock, ctxffd, "it.unibo.clientmock.Clientmock").
 static(clientmock).
