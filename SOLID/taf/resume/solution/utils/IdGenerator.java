package taf.resume.solution.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger compteur = new AtomicInteger(1);

    public static int generateId() {
        return compteur.getAndIncrement();
    }
}
