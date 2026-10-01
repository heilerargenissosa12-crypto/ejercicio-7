package squeakyclean;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Ejercicio 7: Squeaky Clean (Strings Advanced)");
        System.out.println("==================================================");

        // 1. Espacios a guiones bajos
        String t1 = SqueakyClean.clean("my   Id");
        System.out.println("1. Espacios: \"" + t1 + "\" (Esperado: \"my___Id\")");

        // 2. Kebab-case a camelCase
        String t2 = SqueakyClean.clean("a-bc");
        System.out.println("2. Kebab-case: \"" + t2 + "\" (Esperado: \"aBc\")");

        // 3. Leetspeak
        String t3 = SqueakyClean.clean("H3ll0 W0rld");
        System.out.println("3. Leetspeak: \"" + t3 + "\" (Esperado: \"Hello_World\")");

        String t3b = SqueakyClean.clean("4 73s7");
        System.out.println("   Leetspeak 2: \"" + t3b + "\" (Esperado: \"a_test\")");

        // 4. Omitir caracteres especiales
        String t4 = SqueakyClean.clean("a$#.b");
        System.out.println("4. Caracteres especiales omitidos: \"" + t4 + "\" (Esperado: \"ab\")");

        boolean ok = t1.equals("my___Id") &&
                     t2.equals("aBc") &&
                     t3.equals("Hello_World") &&
                     t3b.equals("a_test") &&
                     t4.equals("ab");

        System.out.println("\n[RESULTADO]: " + (ok ? "TODAS LAS PRUEBAS PASARON EXITOSAMENTE" : "ERROR EN LAS PRUEBAS"));
        System.out.println("==================================================\n");
    }
}
