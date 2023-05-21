package parser.Abstract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public abstract class Parser<T> {
    private final List<String> lines;

    public Parser(FileReader fileReader) {
        lines = new BufferedReader(fileReader).lines().toList();
    }

    public List<T> parse() {
        return lines.stream().map(this::parseSingle).toList();
    }

    protected abstract T parseSingle(String str);
}
