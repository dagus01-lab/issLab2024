%====================================================================================
% coldstorageservice description   
%====================================================================================
%====================================================================================
context(ctxroom, "localhost",  "TCP", "8088").
 qactor( coldstorageservice, ctxroom, "it.unibo.coldstorageservice.Coldstorageservice").
 static(coldstorageservice).
  qactor( drivermock, ctxroom, "it.unibo.drivermock.Drivermock").
 static(drivermock).
