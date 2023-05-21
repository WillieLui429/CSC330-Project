package parser.Misc;

import parser.Abstract.Parser;

import java.io.FileReader;

public class MiscParser extends Parser<Misc> {
    public MiscParser(FileReader fileReader) {
        super(fileReader);
    }

    @Override
    protected Misc parseSingle(String str) {
        var arr = str.split(",");
        return new Misc(Integer.parseInt(arr[0]), arr[1], str.split("\"")[1]);
    }
}
