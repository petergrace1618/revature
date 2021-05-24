
class Ploop {
    private parentElement: HTMLElement;
    private tag: string;

    constructor(selector: string, tag: string) {
        this.parentElement = document.querySelector(selector);
        this.tag = tag;
    }

    add(text:string) {
        let el: HTMLElement;
        el = document.createElement(this.tag);
        el.innerHTML = text;
        this.parentElement.append(el);
        return this;
    }
}

new Ploop("body", "p")
    .add("Hello from Ploop")
    .add("More text?!");
new Ploop("ul", "li")
    .add("fork");
new Ploop("body", "h2")
    .add("Another paragraph");



let str:string;
str = 'poooooop';
console.log(str);

let v1 = null;
console.log(v1);

enum Engine
{
OFF = 0,
ON = 1, 
REVERSE = -1
}

function f(p1:number, p2:number): void
{
    console.log(p1,p1);
}

class Poo 
{
    name:string;
    pork:boolean;

    constructor() {
    }

    ability(): void
    {
        console.log('pooooooo');
    }
}

let o:Poo;
o = new Poo();
o.ability();

// class Foo 
// {
//     // automatically declares class property s:string
//     constructor(private s:string) {
//         // and this.s = s;
//     }

//     public get S(): string
//     {
//         return this.s;
//     }
//     public set S(s:string)
//     {
//         this.s = s;
//     }
// }

// let oo:Foo;
// oo = new Foo("blee bloo");
// oo.S = "blah";

interface Animal
{
    name:string;
    isAlive:boolean;
    speed:number;
    speak():string;
    run?(speed?: number): string;
}

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
let fu = (s:string) => {console.log(s);}
fu("suck");

// modules