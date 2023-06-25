let numX = prompt('digite um numero');
let numY = prompt('digite um nuemro');

numX = parseInt(numX);
numY = parseInt(numY);

const resultado = numX / numY;

if (numX == 0 || numY == 0) {
    console.log('divisão impossivel');
} else {
    console.log('o resultado é: ' + resultado)
}