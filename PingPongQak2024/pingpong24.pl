%====================================================================================
% pingpong24 description   
%====================================================================================
dispatch( ball, ball(N) ). %info exchanged
dispatch( ballview, ball(N) ). %observed info
event( startgame, startgame(ARG) ). %event for game start
event( stopgame, stopgame(ARG) ). %event for game end
request( info, info(X) ). %sent by testUnit to observer
reply( obsinfo, obsinfo(X) ).  %%for info
%====================================================================================
context(ctxtest, "localhost",  "TCP", "8020").
 qactor( ping, ctxtest, "it.unibo.ping.Ping").
 static(ping).
  qactor( pong, ctxtest, "it.unibo.pong.Pong").
 static(pong).
  qactor( referee, ctxtest, "it.unibo.referee.Referee").
 static(referee).
tracing.
