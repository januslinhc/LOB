const getData = (a) => {
    var fs = require('fs');
    var readline = require('readline');

    var inputStream = fs.createReadStream('pitch_example_data.txt');
    var lineReader = readline.createInterface({ input: inputStream });
    lineReader.on('line', function(line) {
        if (line.charAt(8) == a) {
            console.log(line);
        }
    });
};


getData('H');
