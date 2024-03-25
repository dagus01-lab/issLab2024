%====================================================================================
% consumer description   
%====================================================================================
dispatch( distance, distance(N) ). %Dispatch inviata dal producer al consumer
request( distance, distance(N) ). %Request inviata dal producer al consumer
dispatch( info, info(N) ).
dispatch( short, short(N) ).
%====================================================================================
context(ctxconsumer, "localhost",  "TCP", "8000").
 qactor( consumer, ctxconsumer, "it.unibo.consumer.Consumer").
 static(consumer).
  qactor( consumerobserver, ctxconsumer, "it.unibo.consumerobserver.Consumerobserver").
 static(consumerobserver).
