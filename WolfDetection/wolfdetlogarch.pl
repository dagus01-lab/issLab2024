%====================================================================================
% wolfdetlogarch description   
%====================================================================================
dispatch( startsonar, startsonar(X) ). %Dispatch NOT a requirement
dispatch( stopsonar, stopsonar(X) ). %Dispatch NOT a requirement
event( obstacle, obstacle(X) ).
request( takePhoto, takePhoto(X) ).
reply( photo, photo(PHOTO) ).  %%for takePhoto
request( detectWolf, detectWolf(PHOTO) ).
reply( iswolf, iswolf(V) ).  %%for detectWolf
dispatch( ledCmd, ledCmd(V) ).
%====================================================================================
context(ctxwdtest, "localhost",  "TCP", "8077").
 qactor( station, ctxwdtest, "it.unibo.station.Station").
 static(station).
  qactor( ledred, ctxwdtest, "it.unibo.ledred.Ledred").
 static(ledred).
  qactor( ledblu, ctxwdtest, "it.unibo.ledblu.Ledblu").
 static(ledblu).
  qactor( camera, ctxwdtest, "it.unibo.camera.Camera").
 static(camera).
  qactor( wolfdetector, ctxwdtest, "it.unibo.wolfdetector.Wolfdetector").
 static(wolfdetector).
  qactor( sonarmock, ctxwdtest, "it.unibo.sonarmock.Sonarmock").
 static(sonarmock).
  qactor( imagesender, ctxwdtest, "it.unibo.imagesender.Imagesender").
 static(imagesender).
