let frutas = new Array("banana", "laranja", "limao");
frutas.shift();
frutas.splice(1, 1, "uva");
for (let i = 0; i<frutas.length; i++)
    console.log(frutas[i] + " / ");