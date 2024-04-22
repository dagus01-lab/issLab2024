%====================================================================================
% wolfdetection description   
%====================================================================================
%====================================================================================
context(ctxwd, "localhost",  "TCP", "8003").
 qactor( stazione, ctxwd, "it.unibo.stazione.Stazione").
 static(stazione).
  qactor( raspberry, ctxwd, "it.unibo.raspberry.Raspberry").
 static(raspberry).
