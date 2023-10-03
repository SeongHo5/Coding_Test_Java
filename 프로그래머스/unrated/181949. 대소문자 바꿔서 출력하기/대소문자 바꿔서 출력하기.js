const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let swappedStr = '';
    for (let i = 0; i < str.length; i++) {
      const currentChar = str.charAt(i);
      if (currentChar === currentChar.toUpperCase()) {
        swappedStr += currentChar.toLowerCase();
      } else {
        swappedStr += currentChar.toUpperCase();
      }
    }
    console.log(swappedStr);
});