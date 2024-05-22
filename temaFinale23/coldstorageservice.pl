%====================================================================================
% coldstorageservice description   
%====================================================================================
request( store, store(N) ).
request( load, load(N) ).
%====================================================================================
context(ctxroom, "localhost",  "TCP", "8088").
 qactor( coldroom, ctxroom, "it.unibo.coldroom.Coldroom").
 static(coldroom).
  qactor( coldstorageservice, ctxroom, "it.unibo.coldstorageservice.Coldstorageservice").
 static(coldstorageservice).
  qactor( drivermock, ctxroom, "it.unibo.drivermock.Drivermock").
 static(drivermock).
