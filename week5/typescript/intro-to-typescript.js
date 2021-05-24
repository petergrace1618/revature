var Ploop = /** @class */ (function () {
    function Ploop(selector, tag) {
        this.parentElement = document.querySelector(selector);
        this.tag = tag;
    }
    Ploop.prototype.add = function (text) {
        var el;
        el = document.createElement(this.tag);
        el.innerHTML = text;
        this.parentElement.append(el);
        return this;
    };
    return Ploop;
}());
new Ploop("body", "p")
    .add("Hello from Ploop")
    .add("More text?!");
new Ploop("ul", "li")
    .add("fork");
new Ploop("body", "h2")
    .add("Another paragraph");
var str;
str = 'poooooop';
console.log(str);
var v1 = null;
console.log(v1);
var Engine;
(function (Engine) {
    Engine[Engine["OFF"] = 0] = "OFF";
    Engine[Engine["ON"] = 1] = "ON";
    Engine[Engine["REVERSE"] = -1] = "REVERSE";
})(Engine || (Engine = {}));
function f(p1, p2) {
    console.log(p1, p1);
}
var Poo = /** @class */ (function () {
    function Poo() {
    }
    Poo.prototype.ability = function () {
        console.log('pooooooo');
    };
    return Poo;
}());
var o;
o = new Poo();
o.ability();
// class Dog implements Animal
// {
//     isAlive: boolean;
//     speed:number;
//     constructor(isAlive:boolean, speed:number) 
//     {
//         this.isAlive = isAlive;
//         this.speed = speed;
//     }
//     speak(verbalization?:string) 
//     {
//         return "woof";
//     }
// }
// arrow
var fu = function (s) { console.log(s); };
fu("suck");
// modules
