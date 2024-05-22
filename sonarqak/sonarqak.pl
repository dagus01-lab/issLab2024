%====================================================================================
% sonarqak description   
%====================================================================================
dispatch( sonarstart, sonarstart(X) ).
dispatch( sonarstop, sonarstop(X) ).
dispatch( doread, doread(X) ).
event( distance, distance(D) ).
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8001").
 qactor( sonar24, ctxsonar, "it.unibo.sonar24.Sonar24").
 static(sonar24).
  qactor( sonardevice, ctxsonar, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).
  qactor( sonarusage, ctxsonar, "it.unibo.sonarusage.Sonarusage").
 static(sonarusage).
