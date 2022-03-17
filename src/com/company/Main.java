package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        Unzipper unzipper = new Unzipper();
        unzipper.unzip(Path.of("data/ft70.atsp.gz"), Path.of("data/ft70.atsp"));
        unzipper.unzip(Path.of("data/ftv33.atsp.gz"), Path.of("data/ftv33.atsp"));

        Parser parser = new Parser();
        Instance instance = new Instance();
        instance.generateRandomInstanceEUC_2D(10,40); //generowanie 10 losowych punktow o wspolrzednych z przedzialu [0,40]
        Solution solution = instance.getSolution(); // tworzenie rozwiazania
        solution.printOrder(); // poczatkowa kolejnosc punktow
        solution.randomOrder(); // permutacja
        solution.printOrder(); // koncowa wartosc punktow

        File file = new File("data/ch150.tsp");
        parser.setParameters(file,instance);
        parser.parseEUC_2D(file,instance);

    }
}
