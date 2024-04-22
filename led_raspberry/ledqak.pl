%====================================================================================
% ledqak description   
%====================================================================================
dispatch( led_on, led_on(N) ). %messaggio di accensione del led
dispatch( led_off, led_off(N) ). %messaggio di spegnimento del led
%====================================================================================
context(ctxled, "localhost",  "TCP", "8001").
 qactor( led, ctxled, "it.unibo.led.Led").
 static(led).
  qactor( ledusage, ctxled, "it.unibo.ledusage.Ledusage").
 static(ledusage).
