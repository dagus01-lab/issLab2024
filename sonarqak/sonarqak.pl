%====================================================================================
% sonarqak description   
%====================================================================================
dispatch( sonarstart, sonarstart(X) ).
dispatch( sonarstop, sonarstop(X) ).
dispatch( doread, doread(X) ).
event( distance, distance(D) ).
dispatch( pause, pause(K) ).
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8001").
context(ctxrobotcleaner, "130.136.113.133",  "TCP", "8032").
 qactor( robotcleaner, ctxrobotcleaner, "it.unibo.robotcleaner.Robotcleaner").
 static(robotcleaner).
  qactor( sonar24, ctxsonar, "it.unibo.sonar24.Sonar24").
 static(sonar24).
  qactor( sonardevice, ctxsonar, "it.unibo.sonardevice.Sonardevice").
 static(sonardevice).
  qactor( sonarusage, ctxsonar, "it.unibo.sonarusage.Sonarusage").
 static(sonarusage).
