//

var classA = function () {
    return {
        foo: function(){ ... },
        bar: function() { ... }
    }
}

var classB = function() {}
classB.protype.foo = function() { ... }
classB.protype.bar = function() { ... }

// 

function foo() {
  ...
}

var foo = function() {
  ...
}

// callApi(...), 15 seconds

callApi(cb1)
callApi(cb2)
callApi(cb3)

cb1(data)
cb2(data)
cb3(data)

var arreglo = [];
arreglo.push(cb);
arreglo.push(cb2);
...


var callSent = false;
var callApi = function(cb){
    arreglo.push(cb);
    
    if(callSent == false){
        callSent = true;
        ApiCall().onSuccess(function(data){
            for(var i = 0; i < arreglo.length;i++) {
                var callback = arreglo[i];
                callback(data);
            }
            arreglo = [];
            callSent = false;
        });
    }
}


// 500ms

var input = $(body).getChild();

var timeout;
input.bind("onKeyPress", function(inputText){
    var flag = false;
    if(timeout) {
        clearTimeout(timeout);
    }
    timeout = setTimeout(function(){
        callApi(inputText); // <-- 
        timeout = undefined;
    },500);
});


myFunction = ...

input.bind("onKeypress", myFunction(callApi, 500));

function myFunction(method, time){  
    var timeout;
    var func = function(){
        if(timeout) {
            clearTimeout(timeout);
        }
        timeout = setTimeout(function(){
            method();// <-- 
            timeout = undefined;
        },time);
    };
    return func;
}
