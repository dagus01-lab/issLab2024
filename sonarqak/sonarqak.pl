%====================================================================================
% sonarqak description   
%====================================================================================
dispatch( sonarstart, sonarstart(X) ).
dispatch( sonarstop, sonarstop(X) ).
event( distance, distance(D) ).
%====================================================================================
context(ctxsonar, "localhost",  "TCP", "8001").
 qactor( datacleaner, ctxsonar, "codedActor.workactor").
 static(datacleaner).
  qactor( distancefilter, ctxsonar, "codedActor.workactor").
 static(distancefilter).
  qactor( sonar, ctxsonar, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( sonarusage, ctxsonar, "it.unibo.sonarusage.Sonarusage").
 static(sonarusage).
