%====================================================================================
% wolfdetreq description   
%====================================================================================
dispatch( startsonar, startsonar(X) ). %Dispatch NOT a requirement
dispatch( stopsonar, stopsonar(X) ). %Dispatch NOT a requirement
%====================================================================================
context(ctxstation, "localhost",  "TCP", "8077").
context(ctxsraspblu, "localhost",  "TCP", "8078").
context(ctxsraspred, "localhost",  "TCP", "8079").
context(ctxsimgrec, "localhost",  "TCP", "8076").
 qactor( station, ctxstation, "it.unibo.station.Station").
 static(station).
  qactor( ledred, ctxsraspred, "it.unibo.ledred.Ledred").
 static(ledred).
  qactor( ledblu, ctxsraspblu, "it.unibo.ledblu.Ledblu").
 static(ledblu).
  qactor( camera, ctxsraspblu, "it.unibo.camera.Camera").
 static(camera).
  qactor( sonarremote, ctxsraspblu, "it.unibo.sonarremote.Sonarremote").
 static(sonarremote).
