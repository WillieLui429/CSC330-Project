package parser.Town;

import parser.Abstract.Parser;

import java.io.FileReader;

public class TownParser extends Parser<Town> {
    public TownParser(FileReader fileReader) {
        super(fileReader);
    }

    @Override
    protected Town parseSingle(String str) {
        var arr = str.split(",");
        return new Town(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), str.split("\"")[1]);
    }
}
