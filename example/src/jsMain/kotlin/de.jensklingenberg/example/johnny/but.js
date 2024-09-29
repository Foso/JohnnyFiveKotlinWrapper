var five = require("johnny-five");
var board = new five.Board();

board.on("ready", function() {

  // Create a new `button` hardware instance.
  var button = new five.Button(2);

  button.on("hold", function(event) {
    console.log( "Button held" + event );
  });

  button.on("press", function() {
    console.log( "Button pressed" );
  });

  button.on("release", function() {
    console.log( "Button released" );
  });
});